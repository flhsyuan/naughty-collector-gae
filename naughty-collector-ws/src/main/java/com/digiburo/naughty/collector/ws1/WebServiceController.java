package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.json.*;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/ws/v1")
public class WebServiceController {
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * POST an authorization test
   * @param request
   * @param location payload
   * @return
   */
  /*
  @RequestMapping(value = "/authorize", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public AuthorizeResponse1 newAuthorize(HttpServletRequest request, HttpServletResponse response, @RequestBody AuthorizeRequest1 authorizeRequest) {
    logger.info("authorize:" + authorizeRequest.getInstallationId());

    AuthorizeHelper helper = new AuthorizeHelper();
    AuthorizeResponse1 authorizeResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString(), authorizeRequest);

    if (AbstractHelper.OK.equals(authorizeResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.AUTH_FAIL.equals(authorizeResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      logger.warning("unknown return status:" + authorizeResponse.getStatus());
    }

    return authorizeResponse;
  }
  */

  /**
   * POST a new observation
   * @param request
   * @param observation payload
   * @return
   */
  /*
  @RequestMapping(value = "/observation", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public ObservationResponse1 newObservation(HttpServletRequest request, HttpServletResponse response, @RequestBody ObservationRequest1 observationRequest) {
    logger.info("newObservation:" + observationRequest.getInstallationId() + ":" + observationRequest.getSortieId());

    ObservationHelper helper = new ObservationHelper();
    ObservationResponse1 observationResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString(), observationRequest);

    if (AbstractHelper.OK.equals(observationResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.AUTH_FAIL.equals(observationResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      logger.warning("unknown return status:" + observationResponse.getStatus());
    }

    return observationResponse;
  }
  */

  /**
   * POST a new sortie
   * @param request
   * @param sortie payload
   * @return
   */
  /*
  @RequestMapping(value = "/sortie", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public SortieResponse1 newSortie(HttpServletRequest request, HttpServletResponse response, @RequestBody SortieRequest1 sortieRequest) {
    logger.info("newSortie:" + sortieRequest.getInstallationId() + ":" + sortieRequest.getSortieId());

    SortieHelper helper = new SortieHelper();
    SortieResponse1 sortieResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString(), sortieRequest);

    if (AbstractHelper.OK.equals(sortieResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.AUTH_FAIL.equals(sortieResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      logger.warning("unknown return status:" + sortieResponse.getStatus());
    }

    return sortieResponse;
  }
  */
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */