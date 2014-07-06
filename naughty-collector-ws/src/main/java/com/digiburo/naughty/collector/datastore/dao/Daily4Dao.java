package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.Daily4;
import com.digiburo.naughty.collector.datastore.entity.Daily4List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  daily4 DAO
 */
public class Daily4Dao extends AbstractDao {

  public void save(final Daily4 arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Daily4.ENTITY_NAME);

    entity.setProperty(Daily4.PROPERTY_DATE, arg.getDate());
    entity.setProperty(Daily4.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(Daily4.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(Daily4.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(Daily4.PROPERTY_VALUE3, arg.getValue3());
    entity.setProperty(Daily4.PROPERTY_VALUE4, arg.getValue4());

    datastoreService.put(entity);
  }

  public Daily4List selectAllDraws() {
    Daily4List results = new Daily4List();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Daily4.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public Daily4 selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Daily4.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Daily4.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    Daily4 result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private Daily4 converter(final Entity entity) {
    Daily4 result = new Daily4();

    result.setDate((Date) entity.getProperty(Daily4.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(Daily4.PROPERTY_DRAW));
    result.setValue1((Long) entity.getProperty(Daily4.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(Daily4.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(Daily4.PROPERTY_VALUE3));
    result.setValue4((Long) entity.getProperty(Daily4.PROPERTY_VALUE4));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */