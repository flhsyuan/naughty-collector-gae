package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.MegaMillionList;
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
public class MegaMillionDaoTest {
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
    Long mega = testHelper.randomLong();
    Long value1 = testHelper.randomLong();
    Long value2 = testHelper.randomLong();
    Long value3 = testHelper.randomLong();
    Long value4 = testHelper.randomLong();
    Long value5 = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setDraw(draw);
    megaMillion.setMega(mega);
    megaMillion.setValue1(value1);
    megaMillion.setValue2(value2);
    megaMillion.setValue3(value3);
    megaMillion.setValue4(value4);
    megaMillion.setValue5(value5);

    MegaMillionDao MegaMillionDao = new MegaMillionDao();
    MegaMillionDao.save(megaMillion);

    MegaMillion selected = MegaMillionDao.selectOne(draw);
    assertEquals(draw.longValue(), selected.getDraw().longValue());
    assertEquals(mega.longValue(), selected.getMega().longValue());
    assertEquals(value1.longValue(), selected.getValue1().longValue());
    assertEquals(value2.longValue(), selected.getValue2().longValue());
    assertEquals(value3.longValue(), selected.getValue3().longValue());
    assertEquals(value4.longValue(), selected.getValue4().longValue());
    assertEquals(value5.longValue(), selected.getValue5().longValue());
  }

  @Test
  public void testSelectAll() {
    MegaMillion megaMillion1 = new MegaMillion();
    MegaMillion megaMillion2 = new MegaMillion();
    MegaMillion megaMillion3 = new MegaMillion();

    megaMillion1.setDraw(testHelper.randomLong());
    megaMillion2.setDraw(testHelper.randomLong());
    megaMillion3.setDraw(testHelper.randomLong());

    MegaMillionDao MegaMillionDao = new MegaMillionDao();
    MegaMillionDao.save(megaMillion1);
    MegaMillionDao.save(megaMillion2);
    MegaMillionDao.save(megaMillion3);

    MegaMillionList megaMillionList = MegaMillionDao.selectAllDraws();
    assertTrue(megaMillionList.size() > 2);
  }
}