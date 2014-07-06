package com.digiburo.naughty.collector.lotto;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

import java.net.URL;

/**
 * Created by gsc on 7/5/14.
 */
public abstract class AbstractLottoCommand {
  public static final String DAILY3_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=daily-3";
  public static final String DAILY4_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=daily-4";
  public static final String FANTASY5_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=fantasy-5";
  public static final String MEGA_MILLION_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=mega-millions";
  public static final String POWER_BALL_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=powerball";
  public static final String SUPER_LOTTO_URL = "http://www.calottery.com/sitecore/content/Miscellaneous/download-numbers?GameName=superlotto-plus";

  /**
   *
   * @param url
   * @return
   */
  String fetcher(String url) {
    String result = "";

    try {
      //TODO need logging
      FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();

      HTTPRequest httpRequest = new HTTPRequest(new URL(url), HTTPMethod.GET, fetchOptions);

      URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
      HTTPResponse response = fetchService.fetch(httpRequest);
      System.out.println(response.getResponseCode());
      if (response.getResponseCode() < 400) {
        result = new String(response.getContent());
      }
    } catch(Exception exception) {
      exception.printStackTrace();
  //    logger.warning(exception.toString());
    }

    return result;
  }

  /**
   *
   */
  public abstract void execute();
}
