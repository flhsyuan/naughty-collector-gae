package com.digiburo.naughty.collector.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * json raw observation response container
 */
public class Observation {
  private Long frequency;
  private Long sample;
  private Long timeStampMs;
  private Date timeStamp = new Date();
  private String observationId;

  public Long getFrequency() {
    return frequency;
  }

  public void setFrequency(Long frequency) {
    this.frequency = frequency;
  }

  public Long getSample() {
    return sample;
  }

  public void setSample(Long sample) {
    this.sample = sample;
  }

  @JsonSerialize(using = Rfc3339DateSerializer.class)
  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Long getTimeStampMs() {
    return timeStampMs;
  }

  public void setTimeStampMs(Long timeStampMs) {
    this.timeStampMs = timeStampMs;
  }

  public String getObservationId() {
    return observationId;
  }

  public void setObservationId(String arg) {
    observationId = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
