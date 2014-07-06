package com.digiburo.naughty.collector.datastore.entity;

import java.util.Date;

/**
 * message receipt
 */
public class Receipt extends AbstractEntity {
  public static final String ENTITY_NAME = "Receipt";

  public static final String PROPERTY_IP_ADDRESS = "ipAddress";
  public static final String PROPERTY_MESSAGE_TYPE = "messageType";
  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";

  public static final String PROPERTY_RECEIPT_UUID = "receiptUuid";

  //
  public static final String DEFAULT_ADDRESS = "No Address";
  public static final String DEFAULT_MESSAGE_TYPE = "No MessageType";

  /**
   * client IP address
   */
  private String ipAddress = DEFAULT_ADDRESS;

  /**
   * message type
   */
  private String messageType = DEFAULT_MESSAGE_TYPE;

  /**
   * free form note
   */
  private String note = DEFAULT_NOTE;

  /**
   * location time in UTC
   */
  private Date timeStamp = new Date();

  /**
   * receipt UUID
   */
  private String receiptUuid = DEFAULT_UUID;

  //////////////////////////////

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String arg) {
    ipAddress = cleaner(arg, "null address", "empty address");
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String arg) {
    messageType = cleaner(arg, "null message type", "empty message type");
  }

  public String getNote() {
    return note;
  }

  public void setNote(String arg) {
    note = cleaner(arg, "null note", "empty note");
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    if (timeStamp == null) {
      throw new NullPointerException("null timeStamp");
    }

    this.timeStamp = timeStamp;
  }

  public String getReceiptUuid() {
    return receiptUuid;
  }

  public void setReceiptUuid(String receiptUuid) {
    this.receiptUuid = cleaner(receiptUuid, "null receiptUuid", "empty receiptUuid");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
