package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.datastore.entity.Daily3List;
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
public class Daily3DaoTest {
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

    Daily3 daily3 = new Daily3();
    daily3.setDraw(draw);
    daily3.setValue1(value1);
    daily3.setValue2(value2);
    daily3.setValue3(value3);

    Daily3Dao daily3Dao = new Daily3Dao();
    daily3Dao.save(daily3);

    Daily3 selected = daily3Dao.selectOne(draw);
    assertEquals(draw.longValue(), selected.getDraw().longValue());
    assertEquals(value1.longValue(), selected.getValue1().longValue());
    assertEquals(value2.longValue(), selected.getValue2().longValue());
    assertEquals(value3.longValue(), selected.getValue3().longValue());
  }

  @Test
  public void testSelectAll() {
    Daily3 daily3a = new Daily3();
    Daily3 daily3b = new Daily3();
    Daily3 daily3c = new Daily3();

    daily3a.setDraw(testHelper.randomLong());
    daily3b.setDraw(testHelper.randomLong());
    daily3c.setDraw(testHelper.randomLong());

    Daily3Dao daily3Dao = new Daily3Dao();
    daily3Dao.save(daily3a);
    daily3Dao.save(daily3b);
    daily3Dao.save(daily3c);

    Daily3List daily3List = daily3Dao.selectAllDraws();
    assertTrue(daily3List.size() > 2);
  }
}
