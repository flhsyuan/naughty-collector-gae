package com.digiburo.naughty.collector.datastore;

import com.digiburo.naughty.collector.datastore.dao.ApplicationLogDao;
import com.digiburo.naughty.collector.datastore.dao.ReceiptDao;
import com.digiburo.naughty.collector.datastore.dao.WxObservationDao;
import com.digiburo.naughty.collector.datastore.dao.WxStationDao;
import com.digiburo.naughty.collector.datastore.entity.WxObservation;
import com.digiburo.naughty.collector.datastore.entity.WxStation;
import com.digiburo.naughty.collector.datastore.entity.WxStationList;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;

import java.util.Date;

/**
 *
 */
public class DataBaseFacade {

  public void writeLog(final LogFacility logFacility, final LogPriority logPriority, final String message) {
    ApplicationLogDao applicationLogDao = new ApplicationLogDao();
    applicationLogDao.writeLog(logFacility, logPriority, message);
  }

  public String generateReceipt(final String ipAddress, final String messageType, final String note) {
    ReceiptDao receiptDao = new ReceiptDao();
    return receiptDao.generateReceipt(ipAddress, messageType, note);
  }

  ////////////////
  //// weather
  ////////////////

  public void saveStation(WxStation arg) {
    WxStationDao wxStationDao = new WxStationDao();
    wxStationDao.save(arg);
  }

  public WxStationList selectAllAirports() {
    WxStationDao wxStationDao = new WxStationDao();
    return wxStationDao.selectAllAirports();
  }


  public void saveObservation(WxObservation arg) {
    WxObservationDao wxObservationDao = new WxObservationDao();
    wxObservationDao.save(arg);
  }

  public WxObservation selectObservation(final String airport, final Date timeStamp) {
    WxObservationDao wxObservationDao = new WxObservationDao();
    return wxObservationDao.selectOne(airport, timeStamp);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */