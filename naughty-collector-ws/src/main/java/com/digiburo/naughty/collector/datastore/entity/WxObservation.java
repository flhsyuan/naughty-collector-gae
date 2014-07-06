package com.digiburo.naughty.collector.datastore.entity;

import com.google.appengine.api.datastore.GeoPt;

import java.util.Date;

/**
 * weather observations
 */
public class WxObservation extends AbstractEntity {
  public static final String ENTITY_NAME = "WxObservation";

  public static final String DEFAULT_AIRPORT = "defaultAirport";
  public static final String DEFAULT_NOTE = "No Note";
  public static final String DEFAULT_WEATHER = "No Weather";

  public static final String PROPERTY_AIRPORT = "airport";
  public static final String PROPERTY_DEWPOINT = "dewpoint";
  public static final String PROPERTY_HUMIDITY = "humidity";
  public static final String PROPERTY_LOCATION = "location";
  public static final String PROPERTY_NOTE = "note";
  public static final String PROPERTY_PRESSURE = "pressure";
  public static final String PROPERTY_TEMPERATURE = "temperature";
  public static final String PROPERTY_TIME_STAMP = "timeStamp";
  public static final String PROPERTY_VISIBILITY = "visibility";
  public static final String PROPERTY_WEATHER = "weather";
  public static final String PROPERTY_WIND_DIRECTION = "windDirection";
  public static final String PROPERTY_WIND_GUST = "windGust";
  public static final String PROPERTY_WIND_SPEED = "windSpeed";

  private String airport = DEFAULT_AIRPORT;
  private Double dewPoint = 0d;
  private Double humidity = 0d;
  private GeoPt location = new GeoPt(0f, 0f);
  private String note = DEFAULT_NOTE;
  private Double pressure = 0d;
  private Double temperature = 0d;
  private Date timeStamp = new Date();
  private Double visibility = 0d;
  private String weather = DEFAULT_WEATHER;
  private Double windDirection = 0d;
  private Double windGust = 0d;
  private Double windSpeed = 0d;

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = cleaner(airport, "null airport", "empty airport");
  }

  public Double getDewPoint() {
    return dewPoint;
  }

  public void setDewPoint(double dewPoint) {
    this.dewPoint = dewPoint;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public GeoPt getLocation() {
    return location;
  }

  public void setLocation(GeoPt location) {
    if (location == null) {
      throw new NullPointerException("null location");
    }

    this.location = location;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = cleaner(note, "null note", "empty note");
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(double pressure) {
    this.pressure = pressure;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
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

  public Double getVisibility() {
    return visibility;
  }

  public void setVisibility(double visibility) {
    this.visibility = visibility;
  }

  public String getWeather() {
    return weather;
  }

  public void setWeather(String weather) {
    this.weather = cleaner(weather, "null weather", "empty weather");
  }

  public Double getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(double windDirection) {
    this.windDirection = windDirection;
  }

  public Double getWindGust() {
    return windGust;
  }

  public void setWindGust(double windGust) {
    this.windGust = windGust;
  }

  public Double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(double windSpeed) {
    this.windSpeed = windSpeed;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */