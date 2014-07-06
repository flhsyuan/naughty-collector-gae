package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.MegaMillionList;
import com.digiburo.naughty.collector.datastore.entity.PowerBall;
import com.digiburo.naughty.collector.datastore.entity.PowerBallList;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/5/14.
 */
public class PowerBallDaoTest {
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
    Long draw = testHelper.randomLong();
    Long powerBallValue = testHelper.randomLong();
    Long value1 = testHelper.randomLong();
    Long value2 = testHelper.randomLong();
    Long value3 = testHelper.randomLong();
    Long value4 = testHelper.randomLong();
    Long value5 = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setDraw(draw);
    powerBall.setPowerBall(powerBallValue);
    powerBall.setValue1(value1);
    powerBall.setValue2(value2);
    powerBall.setValue3(value3);
    powerBall.setValue4(value4);
    powerBall.setValue5(value5);

    PowerBallDao PowerBallDao = new PowerBallDao();
    PowerBallDao.save(powerBall);

    PowerBall selected = PowerBallDao.selectOne(draw);
    assertEquals(draw.longValue(), selected.getDraw().longValue());
    assertEquals(powerBallValue.longValue(), selected.getPowerBall().longValue());
    assertEquals(value1.longValue(), selected.getValue1().longValue());
    assertEquals(value2.longValue(), selected.getValue2().longValue());
    assertEquals(value3.longValue(), selected.getValue3().longValue());
    assertEquals(value4.longValue(), selected.getValue4().longValue());
    assertEquals(value5.longValue(), selected.getValue5().longValue());
  }

  @Test
  public void testSelectAll() {
    PowerBall powerBall1 = new PowerBall();
    PowerBall powerBall2 = new PowerBall();
    PowerBall powerBall3 = new PowerBall();

    powerBall1.setDraw(testHelper.randomLong());
    powerBall2.setDraw(testHelper.randomLong());
    powerBall3.setDraw(testHelper.randomLong());

    PowerBallDao powerBallDao = new PowerBallDao();
    powerBallDao.save(powerBall1);
    powerBallDao.save(powerBall2);
    powerBallDao.save(powerBall3);

    PowerBallList powerBallList = powerBallDao.selectAllDraws();
    assertTrue(powerBallList.size() > 2);
  }
}