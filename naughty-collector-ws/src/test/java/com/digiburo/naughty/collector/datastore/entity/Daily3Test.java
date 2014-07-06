package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by gsc on 6/4/14.
 */
public class Daily3Test {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Daily3 daily3 = new Daily3();

    assertNotNull(daily3.getDate());
    assertEquals(0L, daily3.getDraw().longValue());
    assertEquals(0L, daily3.getValue1().longValue());
    assertEquals(0L, daily3.getValue2().longValue());
    assertEquals(0L, daily3.getValue3().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    Daily3 daily3 = new Daily3();
    daily3.setDate(date);
    assertTrue(date.equals(daily3.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {
    Daily3 daily3 = new Daily3();
    daily3.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    Daily3 daily3 = new Daily3();
    daily3.setDraw(target);
    assertEquals(target.longValue(), daily3.getDraw().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    Daily3 daily3 = new Daily3();
    daily3.setValue1(target);
    assertEquals(target.longValue(), daily3.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    Daily3 daily3 = new Daily3();
    daily3.setValue2(target);
    assertEquals(target.longValue(), daily3.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    Daily3 daily3 = new Daily3();
    daily3.setValue3(target);
    assertEquals(target.longValue(), daily3.getValue3().longValue());
  }
}