package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.datastore.entity.Daily3List;
import com.digiburo.naughty.collector.datastore.entity.Daily4;
import com.digiburo.naughty.collector.datastore.entity.Daily4List;
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
public class Daily4DaoTest {
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
    Long value1 = testHelper.randomLong();
    Long value2 = testHelper.randomLong();
    Long value3 = testHelper.randomLong();
    Long value4 = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setDraw(draw);
    daily4.setValue1(value1);
    daily4.setValue2(value2);
    daily4.setValue3(value3);
    daily4.setValue4(value4);

    Daily4Dao daily4Dao = new Daily4Dao();
    daily4Dao.save(daily4);

    Daily4 selected = daily4Dao.selectOne(draw);
    assertEquals(draw.longValue(), selected.getDraw().longValue());
    assertEquals(value1.longValue(), selected.getValue1().longValue());
    assertEquals(value2.longValue(), selected.getValue2().longValue());
    assertEquals(value3.longValue(), selected.getValue3().longValue());
    assertEquals(value4.longValue(), selected.getValue4().longValue());
  }

  @Test
  public void testSelectAll() {
    Daily4 daily4a = new Daily4();
    Daily4 daily4b = new Daily4();
    Daily4 daily4c = new Daily4();

    daily4a.setDraw(testHelper.randomLong());
    daily4b.setDraw(testHelper.randomLong());
    daily4c.setDraw(testHelper.randomLong());

    Daily4Dao daily4Dao = new Daily4Dao();
    daily4Dao.save(daily4a);
    daily4Dao.save(daily4b);
    daily4Dao.save(daily4c);

    Daily4List daily4List = daily4Dao.selectAllDraws();
    assertTrue(daily4List.size() > 2);
  }
}
