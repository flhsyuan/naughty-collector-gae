package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;

import java.util.logging.Logger;

/**
 * Service Authorize Request
 */
public class AuthorizeHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());
  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  /*
  public AuthorizeResponse1 handler(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    return successResponse(ipAddress, selfUrl, request);
  }

  private AuthorizeResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, request.getInstallationId(), "authorize", "authorize failure");

    AuthorizeResponse1 response = new AuthorizeResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);

    AuthorizeResponse1.Self self = new AuthorizeResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private AuthorizeResponse1 successResponse(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    String receipt = dataBaseFacade.generateReceipt(ipAddress, request.getInstallationId(), "authorize", "authorize success");

    AuthorizeResponse1 response = new AuthorizeResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(OK);

    AuthorizeResponse1.Self self = new AuthorizeResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }
  */
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */
