package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class PowerBallTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    PowerBall powerBall = new PowerBall();

    assertNotNull(powerBall.getDate());
    assertEquals(0L, powerBall.getDraw().longValue());
    assertEquals(0L, powerBall.getPowerBall().longValue());
    assertEquals(0L, powerBall.getValue1().longValue());
    assertEquals(0L, powerBall.getValue2().longValue());
    assertEquals(0L, powerBall.getValue3().longValue());
    assertEquals(0L, powerBall.getValue4().longValue());
    assertEquals(0L, powerBall.getValue5().longValue());
  }

  @Test
  public void dateTest() {
    Date date = new Date();

    PowerBall powerBall = new PowerBall();
    powerBall.setDate(date);
    assertTrue(date.equals(powerBall.getDate()));
  }

  @Test(expected=NullPointerException.class)
  public void nullDateTest() {

    PowerBall powerBall = new PowerBall();
    powerBall.setDate(null);
  }

  @Test
  public void drawTest() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setDraw(target);
    assertEquals(target.longValue(), powerBall.getDraw().longValue());
  }

  @Test
  public void powerBallTest1() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setPowerBall(target);
    assertEquals(target.longValue(), powerBall.getPowerBall().longValue());
  }

  @Test
  public void valueTest1() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setValue1(target);
    assertEquals(target.longValue(), powerBall.getValue1().longValue());
  }

  @Test
  public void valueTest2() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setValue2(target);
    assertEquals(target.longValue(), powerBall.getValue2().longValue());
  }

  @Test
  public void valueTest3() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setValue3(target);
    assertEquals(target.longValue(), powerBall.getValue3().longValue());
  }

  @Test
  public void valueTest4() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setValue4(target);
    assertEquals(target.longValue(), powerBall.getValue4().longValue());
  }

  @Test
  public void valueTest5() {
    Long target = testHelper.randomLong();

    PowerBall powerBall = new PowerBall();
    powerBall.setValue5(target);
    assertEquals(target.longValue(), powerBall.getValue5().longValue());
  }
}