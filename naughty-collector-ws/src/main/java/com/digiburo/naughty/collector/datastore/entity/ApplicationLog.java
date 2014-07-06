package com.digiburo.naughty.collector.datastore.entity;


import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;

import java.util.Date;

/**
 * log entity
 */
public class ApplicationLog extends AbstractEntity {
  public static final String ENTITY_NAME = "ApplicationLog";

  public static final String PROPERTY_FACILITY = "facility";
  public static final String PROPERTY_LEVEL = "level";
  public static final String PROPERTY_MESSAGE = "message";
  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_PRIORITY = "priority";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";

  public static final String DEFAULT_MESSAGE = "No Message";
  public static final String DEFAULT_NOTE = "No Note";

  /**
   * message source
   */
  private LogFacility logFacility = LogFacility.UNKNOWN;

  /**
   * message priority
   */
  private LogPriority logPriority = LogPriority.UNKNOWN;

  /**
   * log message
   */
  private String message = DEFAULT_MESSAGE;

  /**
   * free form note
   */
  private String note = DEFAULT_NOTE;

  /**
   * event time in UTC
   */
  private Date timeStamp = new Date();

  //////

  public LogFacility getLogFacility() {
    return logFacility;
  }

  public void setLogFacility(LogFacility logFacility) {
    if (logFacility == null) {
      throw new NullPointerException("null logFacility");
    }

    this.logFacility = logFacility;
  }

  public LogPriority getLogPriority() {
    return logPriority;
  }

  public void setLogPriority(LogPriority logPriority) {
    if (logPriority == null) {
      throw new NullPointerException("null logPriority");
    }

    this.logPriority = logPriority;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String arg) {
    message = cleaner(arg, "null message", "empty message");
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
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */