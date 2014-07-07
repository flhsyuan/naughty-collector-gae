package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.Daily4;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.Daily4Response1;
import com.digiburo.naughty.collector.json.Fantasy5Response1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class Fantasy5Helper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public Fantasy5Response1 handler(final String ipAddress, final String selfUrl) {
    Fantasy5 fantasy5 = dataBaseFacade.selectLatestFantasy5();
    if (fantasy5 == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(fantasy5, ipAddress, selfUrl);
  }

  public Fantasy5Response1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    Fantasy5 fantasy5 = null;

    try {
      fantasy5 = dataBaseFacade.selectFantasy5(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (fantasy5 == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(fantasy5, ipAddress, tweakedUrl);
  }

  private Fantasy5Response1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "fantasy5", "failure");

    Fantasy5Response1 response = new Fantasy5Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(FAIL);

    response.setLinks(new SelfLinkOnly(selfUrl));

    return response;
  }

  /**
   * service request for latest fantasy5 values
   * @param fantasy5
   * @param ipAddress
   * @param selfUrl
   * @return
   */
  private Fantasy5Response1 successResponse(final Fantasy5 fantasy5, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "fantasy5", "success");

    Fantasy5Response1 response = new Fantasy5Response1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(fantasy5.getDraw());
    response.setDrawDate(fantasy5.getDate());
    response.setValue1(fantasy5.getValue1());
    response.setValue2(fantasy5.getValue2());
    response.setValue3(fantasy5.getValue3());
    response.setValue4(fantasy5.getValue4());
    response.setValue5(fantasy5.getValue5());

    response.setLinks(discoverLinks(fantasy5, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(Fantasy5 fantasy5, String selfUrl) {
    long currentDraw = fantasy5.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    Fantasy5 previousFantasy5 = dataBaseFacade.selectFantasy5(previousDraw);
    Fantasy5 nextFantasy5 = dataBaseFacade.selectFantasy5(nextDraw);

    if (nextFantasy5 == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousFantasy5 == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
