package com.digiburo.naughty.collector.datastore.entity;

import java.util.Date;

import com.digiburo.naughty.collector.TestHelper;

import com.google.appengine.api.datastore.GeoPt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class WxObservationTest {
  private final TestHelper testHelper = new TestHelper();

  public static final double EPSILON = 0.00001;

  @Test
  public void testDefault() {
    WxObservation wxObservation = new WxObservation();

    assertNotNull(wxObservation.getTimeStamp());
    assertNotNull(wxObservation.getLocation());

    assertTrue(WxObservation.DEFAULT_AIRPORT.equals(wxObservation.getAirport()));
    assertTrue(WxObservation.DEFAULT_NOTE.equals(wxObservation.getNote()));
    assertTrue(WxObservation.DEFAULT_WEATHER.equals(wxObservation.getWeather()));

    assertEquals(0d, wxObservation.getDewPoint().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getHumidity().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getPressure().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getTemperature().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getVisibility().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getWindDirection().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getWindGust().doubleValue(), EPSILON);
    assertEquals(0d, wxObservation.getWindSpeed().doubleValue(), EPSILON);
  }

  @Test
  public void dewPointTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setDewPoint(target);
    assertEquals(target.doubleValue(), wxObservation.getDewPoint().doubleValue(), EPSILON);
  }

  @Test
  public void humidityTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setHumidity(target);
    assertEquals(target.doubleValue(), wxObservation.getHumidity().doubleValue(), EPSILON);
  }

  @Test
  public void pressureTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setPressure(target);
    assertEquals(target.doubleValue(), wxObservation.getPressure().doubleValue(), EPSILON);
  }

  @Test
  public void temperatureTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setTemperature(target);
    assertEquals(target.doubleValue(), wxObservation.getTemperature().doubleValue(), EPSILON);
  }

  @Test
  public void visibilityTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setVisibility(target);
    assertEquals(target.doubleValue(), wxObservation.getVisibility().doubleValue(), EPSILON);
  }

  @Test
  public void windDirectionTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setWindDirection(target);
    assertEquals(target.doubleValue(), wxObservation.getWindDirection().doubleValue(), EPSILON);
  }


  @Test
  public void windGustTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setWindGust(target);
    assertEquals(target.doubleValue(), wxObservation.getWindGust().doubleValue(), EPSILON);
  }

  @Test
  public void windSpeedTest() {
    Double target = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setWindSpeed(target);
    assertEquals(target.doubleValue(), wxObservation.getWindSpeed().doubleValue(), EPSILON);
  }

  @Test
  public void locationTest() {
    Float latitude = testHelper.randomFloat();
    Float longitude = testHelper.randomFloat();
    GeoPt target = new GeoPt(latitude, longitude);

    WxObservation wxObservation = new WxObservation();
    wxObservation.setLocation(target);
    assertEquals(latitude.floatValue(), wxObservation.getLocation().getLatitude(), EPSILON);
    assertEquals(longitude.floatValue(), wxObservation.getLocation().getLongitude(), EPSILON);
  }

  @Test(expected=NullPointerException.class)
  public void nullLocationTest() {
    WxObservation wxObservation = new WxObservation();
    wxObservation.setLocation(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setTimeStamp(date);
    assertTrue(date.equals(wxObservation.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    WxObservation wxObservation = new WxObservation();
    wxObservation.setTimeStamp(null);
  }

  @Test
  public void airportTest() {
    String target = testHelper.randomString();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setAirport(target);
    assertTrue(target.equals(wxObservation.getAirport()));
  }

  @Test(expected=NullPointerException.class)
  public void nullAirportTest() {
    WxObservation wxObservation = new WxObservation();
    wxObservation.setAirport(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setNote(target);
    assertTrue(target.equals(wxObservation.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    WxObservation wxObservation = new WxObservation();
    wxObservation.setNote(null);
  }

  @Test
  public void weatherTest() {
    String target = testHelper.randomString();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setWeather(target);
    assertTrue(target.equals(wxObservation.getWeather()));
  }

  @Test(expected=NullPointerException.class)
  public void nullWeatherTest() {
    WxObservation wxObservation = new WxObservation();
    wxObservation.setWeather(null);
  }
}
