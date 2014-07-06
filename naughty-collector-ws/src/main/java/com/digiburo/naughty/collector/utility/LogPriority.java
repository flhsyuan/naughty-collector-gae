package com.digiburo.naughty.collector.utility;

/**
 * define application log event levels
 */
public enum LogPriority {
  UNKNOWN("Unknown", 100),
  EMERGENCY("Emergency", 0),
  ALERT("Alert", 1),
  CRITICAL("Critical", 2),
  ERROR("Error", 3),
  WARNING("Warning", 4),
  NOTICE("Notice", 5),
  INFO("Info", 6),
  DEBUG("Debug", 7);

  private int level;
  private String name;

  /**
   * ctor
   * @param name
   * @param level
   */
  LogPriority(String name, int level) {
    this.name = name;
    this.level = level;
  }

  public int toLevel() {
    return level;
  }

  /**
   * return string of enumerated value
   * @return
   */
  @Override
  public String toString() {
    return name;
  }

  /**
   * map string to enum
   * @param arg
   * @return
   */
  public static LogPriority discoverMatchingEnum(String arg) {
    LogPriority result = LogPriority.UNKNOWN;

    if (arg == null) {
      return result;
    }

    for (LogPriority value:LogPriority.values()) {
      if (value.name.equals(arg)) {
        return value;
      }
    }

    return result;
  }

  /**
   * map level to enum
   * @param arg
   * @return
   */
  public static LogPriority discoverMatchingEnum(int arg) {
    LogPriority result = LogPriority.UNKNOWN;

    for (LogPriority value:LogPriority.values()) {
      if (value.level == arg) {
        return value;
      }
    }

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
