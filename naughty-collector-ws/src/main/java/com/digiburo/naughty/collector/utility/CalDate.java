package com.digiburo.naughty.collector.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Wrapper for java.util.Calendar - only dates, no time
 *
 * @author gsc
 */
public final class CalDate implements Comparable<CalDate> {

  /**
   * Date as represented by this instance.
   */
  private final Calendar value = Calendar.getInstance();

  /**
   * format employed by toString() method, YYYY/MM/DD
   */
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

  /**
   * Smallest legal year
   */
  public static final int MIN_YEAR = 1990;

  /**
   * Largest legal year
   */
  public static final int MAX_YEAR = 2050;

  /**
   * Smallest legal month
   */
  public static final int MIN_MONTH = 0;

  /**
   * Largest legal month
   */
  public static final int MAX_MONTH = 11;

  /**
   * Smallest legal day
   */
  public static final int MIN_DAY = 1;

  /**
   * Largest legal day
   */
  public static final int MAX_DAY = 31;

  /**
   * One day in MilliSeconds
   */
  public static final long DAILY_MILLISECONDS = 24 * 60 * 60 * 1000;

  /**
   * ctor for today
   */
  public CalDate() {
    zeroHourMinute();
  }
  
  /**
   * Create CalDate from Date.
   * Copies values, does not maintain reference to arg.
   * Note that exception leaves original value unchanged.
   * 
   * @param arg date to copy
   * @throws NullPointerException if null arg
   */
  public CalDate(Date arg) {
    if (arg == null) {
      throw new NullPointerException("null Date arg");
    }
      
    value.clear();
    value.setTime(arg);
    
    zeroHourMinute();
  }

  /**
   * Create CalDate from Calendar.
   * Copies values, does not maintain reference to arg.
   * Note that exception leaves original value unchanged.
   * 
   * @param arg date to copy
   * @throws NullPointerException if null arg
   */
  public CalDate(Calendar arg) {
    if (arg == null) {
      throw new NullPointerException("null Calendar arg");
    }
      
    value.clear();
    value.setTimeInMillis(arg.getTimeInMillis());

    zeroHourMinute();
  }       

  /**
   * Define the current date value.  
   *
   * @param year four digit year (1990 to 2020).
   * @param month zero based month (0 to 11).
   * @param day day of month (1 to 31).
   *
   * @throws IllegalArgumentException out of range argument
   */
  public CalDate(int year, int month, int day) {
    if ((year < MIN_YEAR) || (year > MAX_YEAR)) {
      throw new IllegalArgumentException("bad year");
    }

    if ((month < MIN_MONTH) || (month > MAX_MONTH)) {
      throw new IllegalArgumentException("bad month");
    }

    if ((day < MIN_DAY) || (day > MAX_DAY)) {
      throw new IllegalArgumentException("bad day");
    }

    value.clear();
    value.set(year, month, day);

    zeroHourMinute();
  }
  
  /**
   * Define the current date value.  
   * Note that exception leaves original value unchanged.
   *
   * @param arg in the format yyyy/mm/dd
   * @throws NullPointerException if null arg     
   * @throws ParseException if parse failure
   */
  public CalDate(String arg) throws ParseException {
    if (arg == null) {
      throw new NullPointerException("null String arg");
    }

    value.clear();
    value.setTime(sdf.parse(arg));

    zeroHourMinute();
  }

  /**
   * Define the current date value.  
   * Copies values, does not maintain reference to arg.
   * Note that exception leaves original value unchanged.
   *
   * @param arg value to copy
   * @throws NullPointerException if null arg
   */
  public CalDate(CalDate arg) {
    if (arg == null) {
      throw new NullPointerException("null CalDate arg");
    }
      
    value.setTimeInMillis(arg.value.getTimeInMillis());
  }

  /**
   * Bump date for next day.  
   */
  public void setTomorrow() {
    value.add(Calendar.DATE, 1);
  }
  
  /**
   * Decrement date.  
   */
  public void setYesterday() {
    value.add(Calendar.DATE, -1);
  }

  /**
   * Return true if date evaluations to Saturday/Sunday
   *
   * @return true if date evaluations to Saturday/Sunday
   */
  public boolean isWeekEnd() {
    if (value.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
      return(true);
    }

    if (value.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
      return(true);
    }

    return(false);
  }

  /**
   * Return populated calendar instance
   *
   * @return populated calendar instance
   */
  public Calendar getCalendarValue() {
    return((Calendar) value.clone());
  }
  
  /**
   * Return populated date instance
   *
   * @return populated date instance
   */
  public Date getDateValue() {
    return(value.getTime());
  }

  /**
   * Creates and returns a copy of this object
   * 
   * @return populated copy of this object
   */
  public Object clone() {
    return(new CalDate(value));
  }

  /**
   * Return a formatted string representing the state of this instance.
   * Has the form YYYY/MM/DD.
   *
   * @return a formatted string representing the state of this instance.
   */
  public String toString() {
    return(sdf.format(value.getTime()));
  }
  
  /**
   * Return true if I am after arg time
   * 
   * @param arg to compare
   * @return true if I am after arg time
   */
  public boolean after(CalDate arg) {
    return(value.after(arg.getCalendarValue()));
  }

  /**
   * Return true if I am before arg time
   * 
   * @param arg to compare
   * @return true if I am before arg time
   */
  public boolean before(CalDate arg) {
    return(value.before(arg.getCalendarValue()));
  }
  
  /**
   * CalDate always uses the same hours and minutes for any day.
   */
  private void zeroHourMinute() {
    value.set(Calendar.HOUR_OF_DAY, 0);
    value.set(Calendar.MINUTE, 0);
    value.set(Calendar.SECOND, 1);
    value.set(Calendar.MILLISECOND, 0);
  }
  
  /**
   * Support for Comparable.compareTo
   * 
   * @param arg item to compare
   * @return -1 if less, 1 if greater or zero if equal
   * @throws NullPointerException if null arg
   */
  public int compareTo(CalDate arg) {
    if (arg == null) {
      throw new NullPointerException("null CalDate arg");
    }
      
    if (value.after(arg.getCalendarValue())) {
      return(-1);
    }
      
    if (value.before(arg.getCalendarValue())) {
      return(1);
    }
      
    return(0);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CalDate other = (CalDate) obj;
    if (value == null) {
      if (other.value != null) return false;
    } else if (!value.equals(other.value)) return false;
    return true;
  }
}

/*
 * Copyright 2012 Digital Burro, INC
 * Created on Sep 27, 2012 by gsc
 */