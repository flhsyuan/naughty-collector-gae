package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.PowerBall;
import com.digiburo.naughty.collector.datastore.entity.PowerBallList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  power ball DAO
 */
public class PowerBallDao extends AbstractDao {

  public void save(final PowerBall arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(PowerBall.ENTITY_NAME);

    entity.setProperty(PowerBall.PROPERTY_DATE, arg.getDate());
    entity.setProperty(PowerBall.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(PowerBall.PROPERTY_POWER_BALL, arg.getPowerBall());
    entity.setProperty(PowerBall.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(PowerBall.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(PowerBall.PROPERTY_VALUE3, arg.getValue3());
    entity.setProperty(PowerBall.PROPERTY_VALUE4, arg.getValue4());
    entity.setProperty(PowerBall.PROPERTY_VALUE5, arg.getValue5());

    datastoreService.put(entity);
  }

  public PowerBallList selectAllDraws() {
    PowerBallList results = new PowerBallList();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(PowerBall.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public PowerBall selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(PowerBall.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(PowerBall.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    PowerBall result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  public PowerBall selectLatest() {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(PowerBall.ENTITY_NAME);
    query.addSort(PowerBall.PROPERTY_DRAW, Query.SortDirection.DESCENDING);

    PowerBall result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable(FetchOptions.Builder.withLimit(1))) {
      result = converter(entity);
    }

    return result;
  }

  private PowerBall converter(final Entity entity) {
    PowerBall result = new PowerBall();

    result.setDate((Date) entity.getProperty(PowerBall.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(PowerBall.PROPERTY_DRAW));
    result.setPowerBall((Long) entity.getProperty(PowerBall.PROPERTY_POWER_BALL));
    result.setValue1((Long) entity.getProperty(PowerBall.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(PowerBall.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(PowerBall.PROPERTY_VALUE3));
    result.setValue4((Long) entity.getProperty(PowerBall.PROPERTY_VALUE4));
    result.setValue5((Long) entity.getProperty(PowerBall.PROPERTY_VALUE5));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */