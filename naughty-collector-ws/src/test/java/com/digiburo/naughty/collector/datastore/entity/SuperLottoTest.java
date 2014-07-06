package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class SuperLottoTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    SuperLotto superLotto = new SuperLotto();

    assertNotNull(superLotto.getDate());
    assertEquals(0L, superLotto.getDraw().longValue());
    assertEquals(0L, superLotto.getMega().longValue());
    assertEquals(0L, superLotto.getValue1().longValue());
    assertEquals(0L, superLotto.getValue2().longValue());
    assertEquals(0L, superLotto.getValue3().longValue());
    assertEquals(0L, superLotto.getValue4().longValue());
    assertEquals(0L, superLotto.getValue5().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setDate(date);
    assertTrue(date.equals(superLotto.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {
    SuperLotto superLotto = new SuperLotto();
    superLotto.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setDraw(target);
    assertEquals(target.longValue(), superLotto.getDraw().longValue());
  }

  @Test
  public void megaTest1() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setMega(target);
    assertEquals(target.longValue(), superLotto.getMega().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setValue1(target);
    assertEquals(target.longValue(), superLotto.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setValue2(target);
    assertEquals(target.longValue(), superLotto.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setValue3(target);
    assertEquals(target.longValue(), superLotto.getValue3().longValue());
  }

  @Test
  public void valueTest4() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setValue4(target);
    assertEquals(target.longValue(), superLotto.getValue4().longValue());
  }

  @Test
  public void valueTest5() {
    Long target = testHelper.randomLong();

    SuperLotto superLotto = new SuperLotto();
    superLotto.setValue5(target);
    assertEquals(target.longValue(), superLotto.getValue5().longValue());
  }
}