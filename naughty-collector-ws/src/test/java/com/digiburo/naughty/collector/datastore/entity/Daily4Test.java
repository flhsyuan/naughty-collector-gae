package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class Daily4Test {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Daily4 daily4 = new Daily4();

    assertNotNull(daily4.getDate());
    assertEquals(0L, daily4.getDraw().longValue());
    assertEquals(0L, daily4.getValue1().longValue());
    assertEquals(0L, daily4.getValue2().longValue());
    assertEquals(0L, daily4.getValue3().longValue());
    assertEquals(0L, daily4.getValue4().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    Daily4 daily4 = new Daily4();
    daily4.setDate(date);
    assertTrue(date.equals(daily4.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {
    Daily4 daily4 = new Daily4();
    daily4.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setDraw(target);
    assertEquals(target.longValue(), daily4.getDraw().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setValue1(target);
    assertEquals(target.longValue(), daily4.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setValue2(target);
    assertEquals(target.longValue(), daily4.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setValue3(target);
    assertEquals(target.longValue(), daily4.getValue3().longValue());
  }

  @Test
  public void valueTest4() {
    Long target = testHelper.randomLong();

    Daily4 daily4 = new Daily4();
    daily4.setValue4(target);
    assertEquals(target.longValue(), daily4.getValue4().longValue());
  }
}