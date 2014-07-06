package com.digiburo.naughty.collector.json;

/**
 * json observation request container
 *
 * @author gsc
 */
public class ObservationRequest1 {
  private String installationId;
  private String sortieId;
  private ObservationList rawObservationList;

  public String getInstallationId() {
    return installationId;
  }

  public void setInstallationId(String installationId) {
    this.installationId = installationId;
  }

  public String getSortieId() {
    return sortieId;
  }

  public void setSortieId(String sortieId) {
    this.sortieId = sortieId;
  }

  public ObservationList getObservationList() {
    return rawObservationList;
  }

  public void setObservationList(ObservationList arg) {
    rawObservationList = arg;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
