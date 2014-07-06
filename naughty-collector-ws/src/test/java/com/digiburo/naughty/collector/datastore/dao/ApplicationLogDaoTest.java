package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gsc on 6/5/14.
 */
public class ApplicationLogDaoTest {
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
    ApplicationLogDao applicationLogDao = new ApplicationLogDao();
    applicationLogDao.writeLog(LogFacility.TEST, LogPriority.ALERT, "fresh test entry");
  }
}
