package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5List;
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
public class Fantasy5DaoTest {
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
    Long value5 = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setDraw(draw);
    fantasy5.setValue1(value1);
    fantasy5.setValue2(value2);
    fantasy5.setValue3(value3);
    fantasy5.setValue4(value4);
    fantasy5.setValue5(value5);

    Fantasy5Dao fantasy5Dao = new Fantasy5Dao();
    fantasy5Dao.save(fantasy5);

    Fantasy5 selected = fantasy5Dao.selectOne(draw);
    assertEquals(draw.longValue(), selected.getDraw().longValue());
    assertEquals(value1.longValue(), selected.getValue1().longValue());
    assertEquals(value2.longValue(), selected.getValue2().longValue());
    assertEquals(value3.longValue(), selected.getValue3().longValue());
    assertEquals(value4.longValue(), selected.getValue4().longValue());
    assertEquals(value5.longValue(), selected.getValue5().longValue());
  }

  @Test
  public void testSelectAll() {
    Fantasy5 fantasy5a = new Fantasy5();
    Fantasy5 fantasy5b = new Fantasy5();
    Fantasy5 fantasy5c = new Fantasy5();

    fantasy5a.setDraw(testHelper.randomLong());
    fantasy5b.setDraw(testHelper.randomLong());
    fantasy5c.setDraw(testHelper.randomLong());

    Fantasy5Dao fantasy5Dao = new Fantasy5Dao();
    fantasy5Dao.save(fantasy5a);
    fantasy5Dao.save(fantasy5b);
    fantasy5Dao.save(fantasy5c);

    Fantasy5List fantasy5List = fantasy5Dao.selectAllDraws();
    assertTrue(fantasy5List.size() > 2);
  }
}
