package com.digiburo.naughty.collector.datastore.entity;

import java.util.Date;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ApplicationLogTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    ApplicationLog applicationLog = new ApplicationLog();

    assertNotNull(applicationLog.getTimeStamp());

    assertTrue(ApplicationLog.DEFAULT_MESSAGE.equals(applicationLog.getMessage()));
    assertTrue(ApplicationLog.DEFAULT_NOTE.equals(applicationLog.getNote()));

    assertEquals(LogFacility.UNKNOWN, applicationLog.getLogFacility());
    assertEquals(LogPriority.UNKNOWN, applicationLog.getLogPriority());
  }

  @Test
  public void messageTest() {
    String target = testHelper.randomString();

    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setMessage(target);
    assertTrue(target.equals(applicationLog.getMessage()));
  }

  @Test(expected=NullPointerException.class)
  public void nullMessageTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setMessage(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setNote(target);
    assertTrue(target.equals(applicationLog.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setNote(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setTimeStamp(date);
    assertTrue(date.equals(applicationLog.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setTimeStamp(null);
  }

  @Test
  public void logFacilityTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setLogFacility(LogFacility.TEST);
    assertEquals(LogFacility.TEST, applicationLog.getLogFacility());
  }

  @Test(expected=NullPointerException.class)
  public void nullLogFacilityTest() {
    ApplicationLog applicationLog = new ApplicationLog();
    applicationLog.setLogFacility(null);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */