package com.digiburo.naughty.collector.lotto;

/**
 * legal command options
 */
public enum LottoCommand {
  UNKNOWN("Unknown"),
  DAILY3("Daily3"),
  DAILY4("Daily4"),
  FANTASY5("Fantasy5"),
  MEGA_MILLION("MegaMillion"),
  POWER_BALL("PowerBall"),
  SUPER_LOTTO("SuperLotto");

  private String name;

  /**
   * ctor
   * @param arg
   */
  LottoCommand(String arg) {
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
  public static LottoCommand discoverMatchingEnum(String arg) {
    LottoCommand result = LottoCommand.UNKNOWN;

    if (arg == null) {
      return result;
    }

    for (LottoCommand value: LottoCommand.values()) {
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
