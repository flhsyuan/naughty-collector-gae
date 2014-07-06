package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.WxStation;
import com.digiburo.naughty.collector.datastore.entity.WxStationList;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/5/14.
 */
public class WxStationDaoTest {
  private final TestHelper testHelper = new TestHelper();

  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

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
    String airport = testHelper.randomString();
    String airportName = testHelper.randomString();
    String airportNote = testHelper.randomString();

    WxStation wxStation = new WxStation();

    wxStation.setAirport(airport);
    wxStation.setName(airportName);
    wxStation.setNote(airportNote);

    WxStationDao wxStationDao = new WxStationDao();
    wxStationDao.save(wxStation);

    WxStation selected = wxStationDao.selectOne(airport);
    assertTrue(airport.equals(selected.getAirport()));
    assertTrue(airportName.equals(selected.getName()));
    assertTrue(airportNote.equals(selected.getNote()));
  }

  @Test
  public void testSelectAll() {
    WxStationDao wxStationDao = new WxStationDao();

    WxStation wxStation1 = new WxStation();
    wxStation1.setAirport(testHelper.randomString());
    wxStationDao.save(wxStation1);

    WxStation wxStation2 = new WxStation();
    wxStation2.setAirport(testHelper.randomString());
    wxStationDao.save(wxStation2);

    WxStation wxStation3 = new WxStation();
    wxStation3.setAirport(testHelper.randomString());
    wxStationDao.save(wxStation3);

    WxStationList wxStationList = wxStationDao.selectAllAirports();
    assertTrue(wxStationList.size() > 2);
  }
}
