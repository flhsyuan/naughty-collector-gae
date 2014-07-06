package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.digiburo.naughty.collector.datastore.entity.SuperLotto;
import com.digiburo.naughty.collector.datastore.entity.SuperLottoList;
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
public class SuperLottoDaoTest {
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

    SuperLotto superLotto = new SuperLotto();
    superLotto.setDraw(draw);
    superLotto.setMega(mega);
    superLotto.setValue1(value1);
    superLotto.setValue2(value2);
    superLotto.setValue3(value3);
    superLotto.setValue4(value4);
    superLotto.setValue5(value5);

    SuperLottoDao superLottoDao = new SuperLottoDao();
    superLottoDao.save(superLotto);

    SuperLotto selected = superLottoDao.selectOne(draw);
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
    SuperLotto superLotto1 = new SuperLotto();
    SuperLotto superLotto2 = new SuperLotto();
    SuperLotto superLotto3 = new SuperLotto();

    superLotto1.setDraw(testHelper.randomLong());
    superLotto2.setDraw(testHelper.randomLong());
    superLotto3.setDraw(testHelper.randomLong());

    SuperLottoDao superLottoDao = new SuperLottoDao();
    superLottoDao.save(superLotto1);
    superLottoDao.save(superLotto2);
    superLottoDao.save(superLotto3);

    SuperLottoList superLottoList = superLottoDao.selectAllDraws();
    assertTrue(superLottoList.size() > 2);
  }
}