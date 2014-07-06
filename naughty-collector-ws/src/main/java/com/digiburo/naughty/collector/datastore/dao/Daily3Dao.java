package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.datastore.entity.Daily3List;
import com.digiburo.naughty.collector.datastore.entity.WxStation;
import com.digiburo.naughty.collector.datastore.entity.WxStationList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  daily3 DAO
 */
public class Daily3Dao extends AbstractDao {

  public void save(final Daily3 arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Daily3.ENTITY_NAME);

    entity.setProperty(Daily3.PROPERTY_DATE, arg.getDate());
    entity.setProperty(Daily3.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(Daily3.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(Daily3.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(Daily3.PROPERTY_VALUE3, arg.getValue3());

    datastoreService.put(entity);
  }

  public Daily3List selectAllDraws() {
    Daily3List results = new Daily3List();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Daily3.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public Daily3 selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(Daily3.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(Daily3.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    Daily3 result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private Daily3 converter(final Entity entity) {
    Daily3 result = new Daily3();

    result.setDate((Date) entity.getProperty(Daily3.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(Daily3.PROPERTY_DRAW));
    result.setValue1((Long) entity.getProperty(Daily3.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(Daily3.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(Daily3.PROPERTY_VALUE3));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */