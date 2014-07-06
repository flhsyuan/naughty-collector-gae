package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class WxStationTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    WxStation wxStation = new WxStation();

    assertTrue(wxStation.isActive());
    assertTrue(WxStation.DEFAULT_AIRPORT.equals(wxStation.getAirport()));
    assertTrue(WxStation.DEFAULT_NAME.equals(wxStation.getName()));
    assertTrue(WxStation.DEFAULT_NOTE.equals(wxStation.getNote()));
  }

  @Test
  public void activeTest() {
    WxStation wxStation = new WxStation();
    wxStation.setActive(false);
    assertFalse(wxStation.isActive());
    wxStation.setActive(true);
    assertTrue(wxStation.isActive());
  }

  @Test
  public void airportTest() {
    String target = testHelper.randomString();

    WxStation wxStation = new WxStation();
    wxStation.setAirport(target);
    assertTrue(target.equals(wxStation.getAirport()));
  }

  @Test(expected=NullPointerException.class)
  public void nullAirportTest() {
    WxStation wxStation = new WxStation();
    wxStation.setAirport(null);
  }

  @Test
  public void nameTest() {
    String target = testHelper.randomString();

    WxStation wxStation = new WxStation();
    wxStation.setName(target);
    assertTrue(target.equals(wxStation.getName()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNameTest() {
    WxStation wxStation = new WxStation();
    wxStation.setName(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    WxStation wxStation = new WxStation();
    wxStation.setNote(target);
    assertTrue(target.equals(wxStation.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    WxStation wxStation = new WxStation();
    wxStation.setNote(null);
  }
}