package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.Fantasy5;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  fantasy5 DAO
 */
public class Fantasy5Dao extends AbstractDao {

  public void save(final Fantasy5 arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Fantasy5.ENTITY_NAME);

    entity.setProperty(Fantasy5.PROPERTY_DATE, arg.getDate());
    entity.setProperty(Fantasy5.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(Fantasy5.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(Fantasy5.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(Fantasy5.PROPERTY_VALUE3, arg.getValue3());
    entity.setProperty(Fantasy5.PROPERTY_VALUE4, arg.getValue4());
    entity.setProperty(Fantasy5.PROPERTY_VALUE5, arg.getValue5());

    datastoreService.put(entity);
  }

  public Fantasy5List selectAllDraws() {
    Fantasy5List results = new Fantasy5List();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Fantasy5.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public Fantasy5 selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Fantasy5.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Fantasy5.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    Fantasy5 result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private Fantasy5 converter(final Entity entity) {
    Fantasy5 result = new Fantasy5();

    result.setDate((Date) entity.getProperty(Fantasy5.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(Fantasy5.PROPERTY_DRAW));
    result.setValue1((Long) entity.getProperty(Fantasy5.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(Fantasy5.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(Fantasy5.PROPERTY_VALUE3));
    result.setValue4((Long) entity.getProperty(Fantasy5.PROPERTY_VALUE4));
    result.setValue5((Long) entity.getProperty(Fantasy5.PROPERTY_VALUE5));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */