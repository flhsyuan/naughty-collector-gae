package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.Fantasy5Response1;
import com.digiburo.naughty.collector.json.MegaMillionResponse1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class MegaMillionHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public MegaMillionResponse1 handler(final String ipAddress, final String selfUrl) {
    MegaMillion megaMillion = dataBaseFacade.selectLatestMegaMillion();
    if (megaMillion == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(megaMillion, ipAddress, selfUrl);
  }

  public MegaMillionResponse1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    MegaMillion megaMillion = null;

    try {
      megaMillion = dataBaseFacade.selectMegaMillion(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (megaMillion == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(megaMillion, ipAddress, tweakedUrl);
  }

  private MegaMillionResponse1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "megaMillion", "failure");

    MegaMillionResponse1 response = new MegaMillionResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(FAIL);

    response.setLinks(new SelfLinkOnly(selfUrl));

    return response;
  }

  /**
   * service request for latest megaMillion values
   * @param megaMillion
   * @param ipAddress
   * @param selfUrl
   * @return
   */
  private MegaMillionResponse1 successResponse(final MegaMillion megaMillion, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "megaMillion", "success");

    MegaMillionResponse1 response = new MegaMillionResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(megaMillion.getDraw());
    response.setMega(megaMillion.getMega());
    response.setDrawDate(megaMillion.getDate());
    response.setValue1(megaMillion.getValue1());
    response.setValue2(megaMillion.getValue2());
    response.setValue3(megaMillion.getValue3());
    response.setValue4(megaMillion.getValue4());
    response.setValue5(megaMillion.getValue5());

    response.setLinks(discoverLinks(megaMillion, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(MegaMillion megaMillion, String selfUrl) {
    long currentDraw = megaMillion.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    MegaMillion previousMegaMillion = dataBaseFacade.selectMegaMillion(previousDraw);
    MegaMillion nextMegaMillion = dataBaseFacade.selectMegaMillion(nextDraw);

    if (nextMegaMillion == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousMegaMillion == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
