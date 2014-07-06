package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.WxObservation;
import com.digiburo.naughty.collector.datastore.entity.WxObservationList;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/5/14.
 */
public class WxObservationDaoTest {
  private final TestHelper testHelper = new TestHelper();

  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

  public static final double EPSILON = 0.00001;

  @Before
  public void setUp() {
    helper.setUp();
  }

  @After
  public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void testSave() {
    Date date = new Date();

    String airport = testHelper.randomString();
    String note = testHelper.randomString();
    String weather = testHelper.randomString();

    Double dewPoint = testHelper.randomDouble();
    Double humidity = testHelper.randomDouble();
    Double latitude = testHelper.randomDouble();
    Double longitude = testHelper.randomDouble();
    Double pressure = testHelper.randomDouble();
    Double temperature = testHelper.randomDouble();
    Double visibility = testHelper.randomDouble();
    Double windDirection = testHelper.randomDouble();
    Double windGust = testHelper.randomDouble();
    Double windSpeed = testHelper.randomDouble();

    WxObservation wxObservation = new WxObservation();
    wxObservation.setAirport(airport);
    wxObservation.setDewPoint(dewPoint);
    wxObservation.setHumidity(humidity);
    wxObservation.setNote(note);
    wxObservation.setPressure(pressure);
    wxObservation.setTemperature(temperature);
    wxObservation.setTimeStamp(date);
    wxObservation.setVisibility(visibility);
    wxObservation.setWeather(weather);
    wxObservation.setWindDirection(windDirection);
    wxObservation.setWindGust(windGust);
    wxObservation.setWindSpeed(windSpeed);

    WxObservationDao observationDao = new WxObservationDao();
    observationDao.save(wxObservation);

    WxObservation selected = observationDao.selectOne(airport, date);
    assertTrue(airport.equals(selected.getAirport()));
    assertEquals(dewPoint.doubleValue(), selected.getDewPoint().doubleValue(), EPSILON);
    assertEquals(humidity.doubleValue(), selected.getHumidity().doubleValue(), EPSILON);
    assertTrue(note.equals(selected.getNote()));
    assertEquals(pressure.doubleValue(), selected.getPressure().doubleValue(), EPSILON);
    assertEquals(temperature.doubleValue(), selected.getTemperature().doubleValue(), EPSILON);
    assertEquals(visibility.doubleValue(), selected.getVisibility().doubleValue(), EPSILON);
    assertTrue(weather.equals(selected.getWeather()));
    assertEquals(windDirection.doubleValue(), selected.getWindDirection().doubleValue(), EPSILON);
    assertEquals(windGust.doubleValue(), selected.getWindGust().doubleValue(), EPSILON);
    assertEquals(windSpeed.doubleValue(), selected.getWindSpeed().doubleValue(), EPSILON);
  }

  @Test
  public void testSelectAll() {
    String airport = testHelper.randomString();

    WxObservationDao observationDao = new WxObservationDao();

    WxObservation wxObservation1 = new WxObservation();
    wxObservation1.setAirport(airport);
    observationDao.save(wxObservation1);

    WxObservation wxObservation2 = new WxObservation();
    wxObservation2.setAirport(airport);
    observationDao.save(wxObservation2);

    WxObservation wxObservation3 = new WxObservation();
    wxObservation3.setAirport(airport);
    observationDao.save(wxObservation3);

    WxObservationList results = observationDao.selectByAirport(airport);
    assertTrue(results.size() > 2);
  }
}
