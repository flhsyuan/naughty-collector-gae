package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.Daily4;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.Daily4Response1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class Daily4Helper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public Daily4Response1 handler(final String ipAddress, final String selfUrl) {
    Daily4 daily4 = dataBaseFacade.selectLatestDaily4();
    if (daily4 == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(daily4, ipAddress, selfUrl);
  }

  public Daily4Response1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    Daily4 daily4 = null;

    try {
      daily4 = dataBaseFacade.selectDaily4(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (daily4 == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(daily4, ipAddress, tweakedUrl);
  }

  private Daily4Response1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "daily4", "failure");

    Daily4Response1 response = new Daily4Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(FAIL);

    response.setLinks(new SelfLinkOnly(selfUrl));

    return response;
  }

  /**
   * service request for latest daily4 values
   * @param daily3
   * @param ipAddress
   * @param selfUrl
   * @return
   */
  private Daily4Response1 successResponse(final Daily4 daily4, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "daily4", "success");

    Daily4Response1 response = new Daily4Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(daily4.getDraw());
    response.setDrawDate(daily4.getDate());
    response.setValue1(daily4.getValue1());
    response.setValue2(daily4.getValue2());
    response.setValue3(daily4.getValue3());
    response.setValue4(daily4.getValue4());

    response.setLinks(discoverLinks(daily4, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(Daily4 daily4, String selfUrl) {
    long currentDraw = daily4.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    Daily4 previousDaily4 = dataBaseFacade.selectDaily4(previousDraw);
    Daily4 nextDaily4 = dataBaseFacade.selectDaily4(nextDraw);

    if (nextDaily4 == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousDaily4 == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
