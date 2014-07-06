package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.WxStation;
import com.digiburo.naughty.collector.datastore.entity.WxStationList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 *  weather station DAO
 */
public class WxStationDao extends AbstractDao {

  public void save(final WxStation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(WxStation.ENTITY_NAME);

    entity.setProperty(WxStation.PROPERTY_ACTIVE, arg.isActive());
    entity.setProperty(WxStation.PROPERTY_AIRPORT, arg.getAirport());
    entity.setProperty(WxStation.PROPERTY_NAME, arg.getName());
    entity.setProperty(WxStation.PROPERTY_NOTE, arg.getNote());

    datastoreService.put(entity);
  }

  public WxStationList selectAllAirports() {
    WxStationList results = new WxStationList();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(WxStation.ENTITY_NAME);
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public WxStation selectOne(final String airport) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(WxStation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(WxStation.PROPERTY_AIRPORT, Query.FilterOperator.EQUAL, airport));

    WxStation result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  private WxStation converter(final Entity entity) {
    WxStation result = new WxStation();

    result.setActive((Boolean) entity.getProperty(WxStation.PROPERTY_ACTIVE));
    result.setAirport((String) entity.getProperty(WxStation.PROPERTY_AIRPORT));
    result.setName((String) entity.getProperty(WxStation.PROPERTY_NAME));
    result.setNote((String) entity.getProperty(WxStation.PROPERTY_NOTE));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */