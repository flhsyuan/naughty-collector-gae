package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.datastore.entity.WxObservation;
import com.digiburo.naughty.collector.datastore.entity.WxObservationList;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *  weather observation DAO
 */
public class WxObservationDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final WxObservation arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(WxObservation.ENTITY_NAME);

    entity.setProperty(WxObservation.PROPERTY_AIRPORT, arg.getAirport());
    entity.setProperty(WxObservation.PROPERTY_DEWPOINT, arg.getDewPoint());
    entity.setProperty(WxObservation.PROPERTY_HUMIDITY, arg.getHumidity());
    entity.setProperty(WxObservation.PROPERTY_LOCATION, arg.getLocation());
    entity.setProperty(WxObservation.PROPERTY_NOTE, arg.getNote());
    entity.setProperty(WxObservation.PROPERTY_PRESSURE, arg.getPressure());
    entity.setProperty(WxObservation.PROPERTY_TEMPERATURE, arg.getTemperature());
    entity.setProperty(WxObservation.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(WxObservation.PROPERTY_VISIBILITY, arg.getVisibility());
    entity.setProperty(WxObservation.PROPERTY_WEATHER, arg.getWeather());
    entity.setProperty(WxObservation.PROPERTY_WIND_DIRECTION, arg.getWindDirection());
    entity.setProperty(WxObservation.PROPERTY_WIND_GUST, arg.getWindGust());
    entity.setProperty(WxObservation.PROPERTY_WIND_SPEED, arg.getWindSpeed());

    datastoreService.put(entity);
  }

  /**
   * select observations for airport
   * @param arg
   * @return
   */
  public WxObservationList selectByAirport(String arg) {
    WxObservationList results = new WxObservationList();

    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(WxObservation.ENTITY_NAME);
    query.setFilter(new Query.FilterPredicate(WxObservation.PROPERTY_AIRPORT, Query.FilterOperator.EQUAL, arg));
    query.addSort(WxObservation.PROPERTY_TIME_STAMP);

    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      results.add(converter(entity));
    }

    return results;
  }

  public WxObservation selectOne(final String airport, final Date timeStamp) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Query query = new Query(WxObservation.ENTITY_NAME);
    query.setFilter(
        new Query.CompositeFilter(Query.CompositeFilterOperator.AND,
            new ArrayList<Query.Filter>(Arrays.asList(
                new Query.FilterPredicate(WxObservation.PROPERTY_AIRPORT, Query.FilterOperator.EQUAL, airport),
                new Query.FilterPredicate(WxObservation.PROPERTY_TIME_STAMP, Query.FilterOperator.EQUAL, timeStamp)))));

    WxObservation result = null;
    PreparedQuery preparedQuery = datastoreService.prepare(query);
    for (Entity entity:preparedQuery.asIterable()) {
      result = converter(entity);
    }

    return result;
  }

  /**
   *
   * @param entity
   * @return
   */
  private WxObservation converter(Entity entity) {
    WxObservation result = new WxObservation();

    result.setAirport((String) entity.getProperty(WxObservation.PROPERTY_AIRPORT));
    result.setDewPoint((Double) entity.getProperty(WxObservation.PROPERTY_DEWPOINT));
    result.setHumidity((Double) entity.getProperty(WxObservation.PROPERTY_HUMIDITY));
    result.setLocation((GeoPt) entity.getProperty(WxObservation.PROPERTY_LOCATION));
    result.setNote((String) entity.getProperty(WxObservation.PROPERTY_NOTE));
    result.setPressure((Double) entity.getProperty(WxObservation.PROPERTY_PRESSURE));
    result.setTemperature((Double) entity.getProperty(WxObservation.PROPERTY_TEMPERATURE));
    result.setTimeStamp((Date) entity.getProperty(WxObservation.PROPERTY_TIME_STAMP));
    result.setVisibility((Double) entity.getProperty(WxObservation.PROPERTY_VISIBILITY));
    result.setWeather((String) entity.getProperty(WxObservation.PROPERTY_WEATHER));
    result.setWindDirection((Double) entity.getProperty(WxObservation.PROPERTY_WIND_DIRECTION));
    result.setWindGust((Double) entity.getProperty(WxObservation.PROPERTY_WIND_GUST));
    result.setWindSpeed((Double) entity.getProperty(WxObservation.PROPERTY_WIND_SPEED));

    return result;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */