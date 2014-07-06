package com.digiburo.naughty.collector.weather;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.logging.Logger;

/**
 * SAX handler for NWS datum
 *
 * @author gsc
 */
public class XmlHandler extends DefaultHandler {
  private final Logger logger = Logger.getLogger(getClass().getName());

  public static final String BAD_VALUE = "BAD_VALUE";

  private boolean flag = false;

  private String token;

  private ObservationHashMap tokenz = new ObservationHashMap();

  /**
   * Return collected key/value pairs
   * @return collected key/value pairs, might be empty but never null
   */
  public ObservationHashMap getTokens() {
    return(tokenz);
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//    logger.info("startElement");

    flag = true;
    token = BAD_VALUE;
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
 //   logger.info("endElement local:" + localName + ":qName:" + qName + ":uri:" + uri);

    tokenz.put(qName, token);
 //   logger.info("fresh token:" + localName + ":" + token);
    
    flag = false;
  }
  
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
//    logger.info("characters");
    
    if (flag) {
      token = new String(ch, start, length);
//      logger.info("fresh token:" + token);
    }
  }
}

/*
 * Copyright 2011 Digital Burro, INC
 * Created on Jun 17, 2011 by gsc
 */