package com.digiburo.naughty.collector.weather;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.WxObservation;
import com.digiburo.naughty.collector.datastore.entity.WxStation;
import com.digiburo.naughty.collector.datastore.entity.WxStationList;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;
import com.google.appengine.api.datastore.GeoPt;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by gsc on 7/5/14.
 */
public class WeatherHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  private final XmlHandler handler = new XmlHandler();

  public static final String BASE_URL = "http://w1.weather.gov/xml/current_obs/";

  public static final String DEWPOINT_C = "dewpoint_c";
  public static final String LATITUDE = "latitude";
  public static final String LONGITUDE = "longitude";
  public static final String OBSERVATION_TIME = "observation_time_rfc822";
  public static final String PRESSURE_MB = "pressure_mb";
  public static final String RELATIVE_HUMIDITY = "relative_humidity";
  public static final String STATION_ID = "station_id";
  public static final String TEMP_C = "temp_c";
  public static final String VISIBILITY_MI = "visibility_mi";
  public static final String WEATHER = "weather";
  public static final String WIND_DEGREES = "wind_degrees";
  public static final String WIND_GUST_KT = "wind_gust_kt";
  public static final String WIND_KT = "wind_kt";

  /**
   *
   * @param target
   * @return
   */
  private ObservationHashMap readWeather(String target) {
//    logger.info("requesting weather:" + target);

    SAXParserFactory spf = SAXParserFactory.newInstance();

    try {
      SAXParser sp = spf.newSAXParser();
      XMLReader xr = sp.getXMLReader();
      xr.setContentHandler(handler);

      URL url = new URL(BASE_URL + target + ".xml");
      xr.parse(new InputSource(url.openStream()));
    } catch(Exception exception) {
      exception.printStackTrace();
      //   LogFacade.error(LOG_TAG, exception);
    }

    return handler.getTokens();
  }

  private Date rfc822converter(String arg) {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
    try {
      return sdf.parse(arg);
    } catch(ParseException exception) {
      logger.warning("parse error:" + arg);
    }

    return null;
  }

  private WxObservation converter(ObservationHashMap hashMap) {
//    System.out.println("key dump:" + hashMap.size());
//    Set<String> keys = hashMap.keySet();
//    for (String key:keys) {
//      System.out.println(key + ":" + hashMap.get(key));
//    }

    GeoPt location = new GeoPt(Float.parseFloat(hashMap.get(LATITUDE)), Float.parseFloat(hashMap.get(LONGITUDE)));

    WxObservation observation = new WxObservation();
    observation.setAirport(hashMap.get(STATION_ID));
    observation.setLocation(location);
    observation.setTimeStamp(rfc822converter(hashMap.get(OBSERVATION_TIME)));

    if (hashMap.containsKey(DEWPOINT_C)) {
      observation.setDewPoint(Double.parseDouble(hashMap.get(DEWPOINT_C)));
    }

    if (hashMap.containsKey(RELATIVE_HUMIDITY)) {
      observation.setHumidity(Double.parseDouble(hashMap.get(RELATIVE_HUMIDITY)));
    }

    if (hashMap.containsKey(PRESSURE_MB)) {
      observation.setPressure(Double.parseDouble(hashMap.get(PRESSURE_MB)));
    }

    if (hashMap.containsKey(TEMP_C)) {
      observation.setTemperature(Double.parseDouble(hashMap.get(TEMP_C)));
    }

    if (hashMap.containsKey(VISIBILITY_MI)) {
      observation.setVisibility(Double.parseDouble(hashMap.get(VISIBILITY_MI)));
    }

    if (hashMap.containsKey(WEATHER)) {
      observation.setWeather(hashMap.get(WEATHER));
    }

    if (hashMap.containsKey(WIND_DEGREES)) {
      observation.setWindDirection(Double.parseDouble(hashMap.get(WIND_DEGREES)));
    }

    if (hashMap.containsKey(WIND_GUST_KT)) {
      observation.setWindGust(Double.parseDouble(hashMap.get(WIND_GUST_KT)));
    }

    if (hashMap.containsKey(WIND_KT)) {
      observation.setWindSpeed(Double.parseDouble(hashMap.get(WIND_KT)));
    }

    return observation;
  }

  private WxStation createDefaultStation() {
    WxStation wxStation = new WxStation();
    wxStation.setAirport("KRDD");
    wxStation.setName("Redding Municipal");
    return wxStation;
  }

  public void execute() {
    dataBaseFacade.writeLog(LogFacility.WEATHER, LogPriority.INFO, "weather execute");

    WxStationList wxStationList = dataBaseFacade.selectAllAirports();
    if (wxStationList.isEmpty()) {
      WxStation wxStation = createDefaultStation();
      dataBaseFacade.save(wxStation);
      wxStationList.add(wxStation);
    }

    int duplicateObservation = 0;
    int emptyHashMap = 0;

    for (WxStation station:wxStationList) {
      ObservationHashMap hashMap = readWeather(station.getAirport());
      if (hashMap.isEmpty()) {
        ++emptyHashMap;
      } else {
        WxObservation observation = converter(hashMap);
        WxObservation selected = dataBaseFacade.selectObservation(observation.getAirport(), observation.getTimeStamp());
        if (selected == null) {
          dataBaseFacade.save(observation);
        } else {
          ++duplicateObservation;
        }
      }
    }

    dataBaseFacade.writeLog(LogFacility.WEATHER, LogPriority.INFO, "weather updated:" + wxStationList.size() + ":" + emptyHashMap + ":" + duplicateObservation);
  }
}
