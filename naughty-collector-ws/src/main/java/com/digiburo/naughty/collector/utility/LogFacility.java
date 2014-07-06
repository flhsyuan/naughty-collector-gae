package com.digiburo.naughty.collector.utility;

/**
 * define application log event sources
 */
public enum LogFacility{
  UNKNOWN("Unknown"),
  LOTTO("Lotto"),
  WEATHER("Weather"),
  TEST("Test");

  private String name;

  /**
   * ctor
   * @param arg
   */
  LogFacility(String arg) {
    name = arg;
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
  public static LogFacility discoverMatchingEnum(String arg) {
    LogFacility result = LogFacility.UNKNOWN;

    if (arg == null) {
      return result;
    }

    for (LogFacility value:LogFacility.values()) {
      if (value.name.equals(arg)) {
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
