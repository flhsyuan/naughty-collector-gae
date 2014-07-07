package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.SuperLotto;
import com.digiburo.naughty.collector.json.AbstractLinks;
import com.digiburo.naughty.collector.json.MegaMillionResponse1;
import com.digiburo.naughty.collector.json.SelfLinkOnly;
import com.digiburo.naughty.collector.json.SelfNextLink;
import com.digiburo.naughty.collector.json.SelfNextPreviousLink;
import com.digiburo.naughty.collector.json.SelfPreviousLink;
import com.digiburo.naughty.collector.json.SuperLottoResponse1;

import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class SuperLottoHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  public SuperLottoResponse1 handler(final String ipAddress, final String selfUrl) {
    SuperLotto superLotto = dataBaseFacade.selectLatestSuperLotto();
    if (superLotto == null) {
      return failureResponse(ipAddress, selfUrl);
    }

    return successResponse(superLotto, ipAddress, selfUrl);
  }

  public SuperLottoResponse1 handler(final String drawNdx, final String ipAddress, final String selfUrl) {
    int ndx = selfUrl.lastIndexOf("/");
    String tweakedUrl = selfUrl.substring(0, ndx);

    SuperLotto superLotto = null;

    try {
      superLotto = dataBaseFacade.selectSuperLotto(Long.parseLong(drawNdx));
    } catch(Exception exception) {
      //empty
    }

    if (superLotto == null) {
      return failureResponse(ipAddress, tweakedUrl);
    }

    return successResponse(superLotto, ipAddress, tweakedUrl);
  }

  private SuperLottoResponse1 failureResponse(final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "superLotto", "failure");

    SuperLottoResponse1 response = new SuperLottoResponse1();
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
  private SuperLottoResponse1 successResponse(final SuperLotto superLotto, final String ipAddress, final String selfUrl) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, "superLotto", "success");

    SuperLottoResponse1 response = new SuperLottoResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);

    response.setDraw(superLotto.getDraw());
    response.setMega(superLotto.getMega());
    response.setDrawDate(superLotto.getDate());
    response.setValue1(superLotto.getValue1());
    response.setValue2(superLotto.getValue2());
    response.setValue3(superLotto.getValue3());
    response.setValue4(superLotto.getValue4());
    response.setValue5(superLotto.getValue5());

    response.setLinks(discoverLinks(superLotto, selfUrl));

    return response;
  }

  private AbstractLinks discoverLinks(SuperLotto superLotto, String selfUrl) {
    long currentDraw = superLotto.getDraw();
    long previousDraw = currentDraw-1;
    long nextDraw = currentDraw+1;

    String currentUrl = selfUrl + "/" + Long.toString(currentDraw);
    String previousUrl = selfUrl + "/" + Long.toString(previousDraw);
    String nextUrl = selfUrl + "/" + Long.toString(nextDraw);

    SuperLotto previousSuperLotto = dataBaseFacade.selectSuperLotto(previousDraw);
    SuperLotto nextSuperLotto = dataBaseFacade.selectSuperLotto(nextDraw);

    if (nextSuperLotto == null) {
      return new SelfPreviousLink(previousUrl, currentUrl);
    } else if (previousSuperLotto == null) {
      return new SelfNextLink(nextUrl, currentUrl);
    }

    return new SelfNextPreviousLink(nextUrl, previousUrl, currentUrl);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
