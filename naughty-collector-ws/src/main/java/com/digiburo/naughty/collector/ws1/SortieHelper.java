package com.digiburo.naughty.collector.ws1;


import com.digiburo.naughty.collector.datastore.DataBaseFacade;

import java.util.Date;
import java.util.logging.Logger;

/**
 *  process a fresh JSON message
 */
public class SortieHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  /**
   *
   * @param ipAddress
   * @param selfUrl
   * @param sortieRequest
   * @return
   */
  /*
  public SortieResponse1 handler(final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    int rowCount = persist(request);

    return successResponse(rowCount, ipAddress, selfUrl, request);
  }

  private SortieResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, request.getInstallationId(), "sortie", "authorize failure");

    SortieResponse1 response = new SortieResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);
    response.setSortieId(request.getSortieId());
    response.setRowCount(0);

    SortieResponse1.Self self = new SortieResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private SortieResponse1 successResponse(int rowCount, final String ipAddress, final String selfUrl, final SortieRequest1 request) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, request.getInstallationId(), "sortie", "sortie success:" + rowCount);

    SortieResponse1 response = new SortieResponse1();
    response.setReceipt(receipt);
    response.setRemoteIpAddress(ipAddress);
    response.setStatus(OK);
    response.setSortieId(request.getSortieId());
    response.setRowCount(rowCount);

    SortieResponse1.Self self = new SortieResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }
  */

  /**
   * Convert from client JSON format and persist to datastore
   * @param request
   * @return row count
   */
  /*
  private int persist(final SortieRequest1 request) {
    logger.info("persist");

    int count = 0;
    Sortie sortie = dataBaseFacade.selectSortie(request.getSortieId());

    if (sortie == null) {
      Date timeStamp = new Date(request.getTimeStampMs());

      dataBaseFacade.saveSortie(timeStamp, request.getInstallationId(), request.getSortieId(), request.getSortieName());

      ++count;
    } else {
      logger.fine("duplicate sortie:" + request.getSortieId());
    }

    return count;
  }
  */
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
