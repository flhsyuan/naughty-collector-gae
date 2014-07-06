package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.ApplicationLog;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

/**
 *  log DAO
 */
public class ApplicationLogDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final ApplicationLog arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(ApplicationLog.ENTITY_NAME);

    entity.setProperty(ApplicationLog.PROPERTY_FACILITY, arg.getLogFacility().toString());
    entity.setProperty(ApplicationLog.PROPERTY_LEVEL, arg.getLogPriority().toLevel());
    entity.setProperty(ApplicationLog.PROPERTY_MESSAGE, arg.getMessage());
    entity.setProperty(ApplicationLog.PROPERTY_NOTE, arg.getNote());
    entity.setProperty(ApplicationLog.PROPERTY_PRIORITY, arg.getLogPriority().toString());
    entity.setProperty(ApplicationLog.PROPERTY_TIME_STAMP, arg.getTimeStamp());

    datastoreService.put(entity);
  }

  /**
   * persist a log entry
   * @param note
   */
  public void writeLog(final LogFacility logFacility, final LogPriority logPriority, final String message) {
    ApplicationLog applicationLog = new ApplicationLog();

    applicationLog.setLogFacility(logFacility);
    applicationLog.setLogPriority(logPriority);
    applicationLog.setMessage(message);

    save(applicationLog);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
