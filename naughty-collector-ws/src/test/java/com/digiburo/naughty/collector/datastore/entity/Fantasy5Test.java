package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class Fantasy5Test {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Fantasy5 fantasy5 = new Fantasy5();

    assertNotNull(fantasy5.getDate());
    assertEquals(0L, fantasy5.getDraw().longValue());
    assertEquals(0L, fantasy5.getValue1().longValue());
    assertEquals(0L, fantasy5.getValue2().longValue());
    assertEquals(0L, fantasy5.getValue3().longValue());
    assertEquals(0L, fantasy5.getValue4().longValue());
    assertEquals(0L, fantasy5.getValue5().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setDate(date);
    assertTrue(date.equals(fantasy5.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setDraw(target);
    assertEquals(target.longValue(), fantasy5.getDraw().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setValue1(target);
    assertEquals(target.longValue(), fantasy5.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setValue2(target);
    assertEquals(target.longValue(), fantasy5.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setValue3(target);
    assertEquals(target.longValue(), fantasy5.getValue3().longValue());
  }

  @Test
  public void valueTest4() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setValue4(target);
    assertEquals(target.longValue(), fantasy5.getValue4().longValue());
  }

  @Test
  public void valueTest5() {
    Long target = testHelper.randomLong();

    Fantasy5 fantasy5 = new Fantasy5();
    fantasy5.setValue5(target);
    assertEquals(target.longValue(), fantasy5.getValue5().longValue());
  }
}