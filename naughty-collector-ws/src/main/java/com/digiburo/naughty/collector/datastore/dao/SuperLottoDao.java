package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.SuperLotto;
import com.digiburo.naughty.collector.datastore.entity.SuperLottoList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.Date;

/**
 *  superlotto DAO
 */
public class SuperLottoDao extends AbstractDao {

  public void save(final SuperLotto arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(SuperLotto.ENTITY_NAME);

    entity.setProperty(SuperLotto.PROPERTY_DATE, arg.getDate());
    entity.setProperty(SuperLotto.PROPERTY_DRAW, arg.getDraw());
    entity.setProperty(SuperLotto.PROPERTY_MEGA, arg.getMega());
    entity.setProperty(SuperLotto.PROPERTY_VALUE1, arg.getValue1());
    entity.setProperty(SuperLotto.PROPERTY_VALUE2, arg.getValue2());
    entity.setProperty(SuperLotto.PROPERTY_VALUE3, arg.getValue3());
    entity.setProperty(SuperLotto.PROPERTY_VALUE4, arg.getValue4());
    entity.setProperty(SuperLotto.PROPERTY_VALUE5, arg.getValue5());

    datastoreService.put(entity);
  }

  public SuperLottoList selectAllDraws() {
    SuperLottoList results = new SuperLottoList();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(SuperLotto.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public SuperLotto selectOne(final Long draw) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(SuperLotto.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(SuperLotto.PROPERTY_DRAW, Query.FilterOperator.EQUAL, draw));

    SuperLotto result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private SuperLotto converter(final Entity entity) {
    SuperLotto result = new SuperLotto();

    result.setDate((Date) entity.getProperty(SuperLotto.PROPERTY_DATE));
    result.setDraw((Long) entity.getProperty(SuperLotto.PROPERTY_DRAW));
    result.setMega((Long) entity.getProperty(SuperLotto.PROPERTY_MEGA));
    result.setValue1((Long) entity.getProperty(SuperLotto.PROPERTY_VALUE1));
    result.setValue2((Long) entity.getProperty(SuperLotto.PROPERTY_VALUE2));
    result.setValue3((Long) entity.getProperty(SuperLotto.PROPERTY_VALUE3));
    result.setValue4((Long) entity.getProperty(SuperLotto.PROPERTY_VALUE4));
    result.setValue5((Long) entity.getProperty(SuperLotto.PROPERTY_VALUE5));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */