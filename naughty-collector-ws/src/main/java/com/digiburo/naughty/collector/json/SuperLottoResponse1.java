package com.digiburo.naughty.collector.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json super lotto response container
 *
 * @author gsc
 */
public class SuperLottoResponse1 {
  private String ipAddress;
  private String receipt;
  private String status;
  private Date drawDate = new Date();
  private Long draw = 0L;
  private Long mega = 0L;
  private Long value1 = 0L;
  private Long value2 = 0L;
  private Long value3 = 0L;
  private Long value4 = 0L;
  private Long value5 = 0L;

  @JsonProperty("_links")
  private AbstractLinks links;

  public AbstractLinks getLinks() {
    return links;
  }

  public void setLinks(AbstractLinks arg) {
    links = arg;
  }

  public String getReceipt() {
    return receipt;
  }

  public void setReceipt(String receipt) {
    this.receipt = receipt;
  }

  public String getRemoteIpAddress() {
    return ipAddress;
  }

  public void setRemoteIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @JsonSerialize(using = Rfc3339DateSerializer.class)
  public Date getDrawDate() {
    return drawDate;
  }

  public void setDrawDate(Date arg) {
    drawDate = arg;
  }

  public Long getDraw() {
    return draw;
  }

  public void setDraw(Long arg) {
    draw = arg;
  }

  public Long getMega() {
    return mega;
  }

  public void setMega(Long arg) {
    mega = arg;
  }

  public Long getValue1() {
    return value1;
  }

  public void setValue1(Long arg) {
    value1 = arg;
  }

  public Long getValue2() {
    return value2;
  }

  public void setValue2(Long arg) {
    value2 = arg;
  }

  public Long getValue3() {
    return value3;
  }

  public void setValue3(Long arg) {
    value3 = arg;
  }

  public Long getValue4() {
    return value4;
  }

  public void setValue4(Long arg) {
    value4 = arg;
  }

  public Long getValue5() {
    return value5;
  }

  public void setValue5(Long arg) {
    value5 = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
