package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.MegaMillionList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  megamillion DAO
 */
public class MegaMillionDao extends AbstractDao {

  public void save(final MegaMillion arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(MegaMillion.ENTITY_NAME);

    entity.setProperty(MegaMillion.PROPERTY_DATE, arg.getDate());
    entity.setProperty(MegaMillion.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(MegaMillion.PROPERTY_MEGA, arg.getMega());
    entity.setProperty(MegaMillion.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(MegaMillion.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(MegaMillion.PROPERTY_VALUE3, arg.getValue3());
    entity.setProperty(MegaMillion.PROPERTY_VALUE4, arg.getValue4());
    entity.setProperty(MegaMillion.PROPERTY_VALUE5, arg.getValue5());

    datastoreService.put(entity);
  }

  public MegaMillionList selectAllDraws() {
    MegaMillionList results = new MegaMillionList();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(MegaMillion.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public MegaMillion selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(MegaMillion.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(MegaMillion.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    MegaMillion result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private MegaMillion converter(final Entity entity) {
    MegaMillion result = new MegaMillion();

    result.setDate((Date) entity.getProperty(MegaMillion.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(MegaMillion.PROPERTY_DRAW));
    result.setMega((Long) entity.getProperty(MegaMillion.PROPERTY_MEGA));
    result.setValue1((Long) entity.getProperty(MegaMillion.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(MegaMillion.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(MegaMillion.PROPERTY_VALUE3));
    result.setValue4((Long) entity.getProperty(MegaMillion.PROPERTY_VALUE4));
    result.setValue5((Long) entity.getProperty(MegaMillion.PROPERTY_VALUE5));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */