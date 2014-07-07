package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.Daily3Response1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class Daily3Helper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public Daily3Response1 handler(final String ipAddress, final String selfUrl) {
    Daily3 daily3 = dataBaseFacade.selectLatestDaily3();
    if (daily3 == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(daily3, ipAddress, selfUrl);
  }

  public Daily3Response1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    Daily3 daily3 = null;

    try {
      daily3 = dataBaseFacade.selectDaily3(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (daily3 == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(daily3, ipAddress, tweakedUrl);
  }

  private Daily3Response1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "daily3", "failure");

    Daily3Response1 response = new Daily3Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(FAIL);

    response.setLinks(new SelfLinkOnly(selfUrl));

    return response;
  }

  /**
   * service request for latest daily3 values
   * @param daily3
   * @param ipAddress
   * @param selfUrl
   * @return
   */
  private Daily3Response1 successResponse(final Daily3 daily3, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "daily3", "success");

    Daily3Response1 response = new Daily3Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(daily3.getDraw());
    response.setDrawDate(daily3.getDate());
    response.setValue1(daily3.getValue1());
    response.setValue2(daily3.getValue2());
    response.setValue3(daily3.getValue3());

    response.setLinks(discoverLinks(daily3, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(Daily3 daily3, String selfUrl) {
    long currentDraw = daily3.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    Daily3 previousDaily3 = dataBaseFacade.selectDaily3(previousDraw);
    Daily3 nextDaily3 = dataBaseFacade.selectDaily3(nextDraw);

    if (nextDaily3 == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousDaily3 == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
