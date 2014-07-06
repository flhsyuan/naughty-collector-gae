package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class MegaMillionTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    MegaMillion megaMillion = new MegaMillion();

    assertNotNull(megaMillion.getDate());
    assertEquals(0L, megaMillion.getDraw().longValue());
    assertEquals(0L, megaMillion.getMega().longValue());
    assertEquals(0L, megaMillion.getValue1().longValue());
    assertEquals(0L, megaMillion.getValue2().longValue());
    assertEquals(0L, megaMillion.getValue3().longValue());
    assertEquals(0L, megaMillion.getValue4().longValue());
    assertEquals(0L, megaMillion.getValue5().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setDate(date);
    assertTrue(date.equals(megaMillion.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {
    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setDraw(target);
    assertEquals(target.longValue(), megaMillion.getDraw().longValue());
  }

  @Test
  public void megaTest1() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setMega(target);
    assertEquals(target.longValue(), megaMillion.getMega().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setValue1(target);
    assertEquals(target.longValue(), megaMillion.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setValue2(target);
    assertEquals(target.longValue(), megaMillion.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setValue3(target);
    assertEquals(target.longValue(), megaMillion.getValue3().longValue());
  }

  @Test
  public void valueTest4() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setValue4(target);
    assertEquals(target.longValue(), megaMillion.getValue4().longValue());
  }

  @Test
  public void valueTest5() {
    Long target = testHelper.randomLong();

    MegaMillion megaMillion = new MegaMillion();
    megaMillion.setValue5(target);
    assertEquals(target.longValue(), megaMillion.getValue5().longValue());
  }
}