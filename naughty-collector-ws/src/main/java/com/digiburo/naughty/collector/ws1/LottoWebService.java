package com.digiburo.naughty.collector.ws1;

import com.digiburo.naughty.collector.json.Daily3Response1;
import com.digiburo.naughty.collector.json.Daily4Response1;
import com.digiburo.naughty.collector.json.Fantasy5Response1;
import com.digiburo.naughty.collector.json.MegaMillionResponse1;
import com.digiburo.naughty.collector.json.PowerBallResponse1;
import com.digiburo.naughty.collector.json.SuperLottoResponse1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ws/lotto/v1")
public class LottoWebService {
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/daily3", method = RequestMethod.GET)
  @ResponseBody
  public Daily3Response1 latestDaily3(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestDaily3");

    Daily3Helper helper = new Daily3Helper();
    Daily3Response1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/daily3/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public Daily3Response1 singleDaily3(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singleDaily3:" + drawNdx);

    Daily3Helper helper = new Daily3Helper();
    Daily3Response1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/daily4", method = RequestMethod.GET)
  @ResponseBody
  public Daily4Response1 latestDaily4(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestDaily4");

    Daily4Helper helper = new Daily4Helper();
    Daily4Response1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/daily4/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public Daily4Response1 singleDaily4(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singleDaily4:" + drawNdx);

    Daily4Helper helper = new Daily4Helper();
    Daily4Response1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/fantasy5", method = RequestMethod.GET)
  @ResponseBody
  public Fantasy5Response1 latestFantasy5(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestFantasy5");

    Fantasy5Helper helper = new Fantasy5Helper();
    Fantasy5Response1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/fantasy5/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public Fantasy5Response1 singleFantasy5(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singleFantasy5:" + drawNdx);

    Fantasy5Helper helper = new Fantasy5Helper();
    Fantasy5Response1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/megamillion", method = RequestMethod.GET)
  @ResponseBody
  public MegaMillionResponse1 latestMegaMillion(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestMegaMillion");

    MegaMillionHelper helper = new MegaMillionHelper();
    MegaMillionResponse1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/megamillion/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public MegaMillionResponse1 singleMegaMillion(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singleMegaMillion:" + drawNdx);

    MegaMillionHelper helper = new MegaMillionHelper();
    MegaMillionResponse1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/powerball", method = RequestMethod.GET)
  @ResponseBody
  public PowerBallResponse1 latestPowerBall(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestPowerBall");

    PowerBallHelper helper = new PowerBallHelper();
    PowerBallResponse1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/powerball/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public PowerBallResponse1 singlePowerBall(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singlePowerBall:" + drawNdx);

    PowerBallHelper helper = new PowerBallHelper();
    PowerBallResponse1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  /**
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/superlotto", method = RequestMethod.GET)
  @ResponseBody
  public SuperLottoResponse1 latestSuperLotto(HttpServletRequest request, HttpServletResponse response) {
    logger.info("latestSuperLotto");

    SuperLottoHelper helper = new SuperLottoHelper();
    SuperLottoResponse1 helperResponse = helper.handler(request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }

  @RequestMapping(value = "/superlotto/{drawNdx}", method = RequestMethod.GET)
  @ResponseBody
  public SuperLottoResponse1 singleSuperLotto(HttpServletRequest request, @PathVariable String drawNdx, HttpServletResponse response) {
    logger.info("singleSuperLotto:" + drawNdx);

    SuperLottoHelper helper = new SuperLottoHelper();
    SuperLottoResponse1 helperResponse = helper.handler(drawNdx, request.getRemoteAddr(), request.getRequestURL().toString());

    if (AbstractHelper.OK.equals(helperResponse.getStatus())) {
      // fall through
    } else if (AbstractHelper.FAIL.equals(helperResponse.getStatus())) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else {
      logger.warning("unknown return status:" + helperResponse.getStatus());
    }

    return helperResponse;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */