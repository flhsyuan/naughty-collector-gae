package com.digiburo.naughty.collector.datastore.entity;

/**
 * weather observation stations
 */
public class WxStation extends AbstractEntity {
  public static final String ENTITY_NAME = "WxStation";

  public static final String DEFAULT_AIRPORT = "defaultAirport";
  public static final String DEFAULT_NAME = "defaultName";
  public static final String DEFAULT_NOTE = "No Note";

  public static final String PROPERTY_ACTIVE = "active";
  public static final String PROPERTY_AIRPORT = "airport";
  public static final String PROPERTY_NAME = "name";
  public static final String PROPERTY_NOTE = "note";

  private Boolean active = true;
  private String airport = DEFAULT_AIRPORT;
  private String name = DEFAULT_NAME;
  private String note = DEFAULT_NOTE;

  public Boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = cleaner(airport, "null airport", "empty airport");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = cleaner(name, "null name", "empty name");
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = cleaner(note, "null note", "empty note");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */