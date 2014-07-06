package com.digiburo.naughty.collector.datastore.entity;

import java.util.Date;

/**
 * powerball container
 */
public class PowerBall extends AbstractEntity {
  public static final String ENTITY_NAME = "PowerBall";

  public static final String PROPERTY_POWER_BALL = "powerBall";
  public static final String PROPERTY_DATE = "date";
  public static final String PROPERTY_DRAW = "draw";
  public static final String PROPERTY_VALUE1 = "value1";
  public static final String PROPERTY_VALUE2 = "value2";
  public static final String PROPERTY_VALUE3 = "value3";
  public static final String PROPERTY_VALUE4 = "value4";
  public static final String PROPERTY_VALUE5 = "value5";

  private Long powerBall = 0L;
  private Date date = new Date();
  private Long draw = 0L;
  private Long value1 = 0L;
  private Long value2 = 0L;
  private Long value3 = 0L;
  private Long value4 = 0L;
  private Long value5 = 0L;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    if (date == null) {
      throw new NullPointerException("null date");
    }

    this.date = date;
  }

  public Long getDraw() {
    return draw;
  }

  public void setDraw(long draw) {
    this.draw = draw;
  }

  public Long getPowerBall() {
    return powerBall;
  }

  public void setPowerBall(long arg) {
    powerBall = arg;
  }

  public Long getValue1() {
    return value1;
  }

  public void setValue1(long value1) {
    this.value1 = value1;
  }

  public Long getValue2() {
    return value2;
  }

  public void setValue2(long value2) {
    this.value2 = value2;
  }

  public Long getValue3() {
    return value3;
  }

  public void setValue3(long value3) {
    this.value3 = value3;
  }

  public Long getValue4() {
    return value4;
  }

  public void setValue4(long value4) {
    this.value4 = value4;
  }

  public Long getValue5() {
    return value5;
  }

  public void setValue5(long value5) {
    this.value5 = value5;
  }

  @Override
  public String toString() {
    return("PowerBall:" + draw + ":" + value1 + ":" + value2 + ":" + value3 + ":" + value4 + ":" + value5 + ":" + powerBall + ":" + date);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */