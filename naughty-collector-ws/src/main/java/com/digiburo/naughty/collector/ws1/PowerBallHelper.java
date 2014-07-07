package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.PowerBall;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.MegaMillionResponse1;
import com.digiburo.naughty.collector.json.PowerBallResponse1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class PowerBallHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public PowerBallResponse1 handler(final String ipAddress, final String selfUrl) {
    PowerBall powerBall = dataBaseFacade.selectLatestPowerBall();
    if (powerBall == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(powerBall, ipAddress, selfUrl);
  }

  public PowerBallResponse1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    PowerBall powerBall = null;

    try {
      powerBall = dataBaseFacade.selectPowerBall(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (powerBall == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(powerBall, ipAddress, tweakedUrl);
  }

  private PowerBallResponse1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "powerBall", "failure");

    PowerBallResponse1 response = new PowerBallResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(FAIL);

    response.setLinks(new SelfLinkOnly(selfUrl));

    return response;
  }

  /**
   * service request for latest powerball values
   * @param megaMillion
   * @param ipAddress
   * @param selfUrl
   * @return
   */
  private PowerBallResponse1 successResponse(final PowerBall powerBall, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "powerBall", "success");

    PowerBallResponse1 response = new PowerBallResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(powerBall.getDraw());
    response.setPowerBall(powerBall.getPowerBall());
    response.setDrawDate(powerBall.getDate());
    response.setValue1(powerBall.getValue1());
    response.setValue2(powerBall.getValue2());
    response.setValue3(powerBall.getValue3());
    response.setValue4(powerBall.getValue4());
    response.setValue5(powerBall.getValue5());

    response.setLinks(discoverLinks(powerBall, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(PowerBall powerBall, String selfUrl) {
    long currentDraw = powerBall.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    PowerBall previousPowerBall = dataBaseFacade.selectPowerBall(previousDraw);
    PowerBall nextPowerBall = dataBaseFacade.selectPowerBall(nextDraw);

    if (nextPowerBall == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousPowerBall == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
