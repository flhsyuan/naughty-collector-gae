package com.digiburo.naughty.collector.datastore;

import com.digiburo.naughty.collector.datastore.dao.ApplicationLogDao;
import com.digiburo.naughty.collector.datastore.dao.Daily3Dao;
import com.digiburo.naughty.collector.datastore.dao.Daily4Dao;
import com.digiburo.naughty.collector.datastore.dao.Fantasy5Dao;
import com.digiburo.naughty.collector.datastore.dao.MegaMillionDao;
import com.digiburo.naughty.collector.datastore.dao.PowerBallDao;
import com.digiburo.naughty.collector.datastore.dao.ReceiptDao;
import com.digiburo.naughty.collector.datastore.dao.SuperLottoDao;
import com.digiburo.naughty.collector.datastore.dao.WxObservationDao;
import com.digiburo.naughty.collector.datastore.dao.WxStationDao;
import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.datastore.entity.Daily4;
import com.digiburo.naughty.collector.datastore.entity.Fantasy5;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.datastore.entity.PowerBall;
import com.digiburo.naughty.collector.datastore.entity.SuperLotto;
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

  public void save(WxStation arg) {
    WxStationDao wxStationDao = new WxStationDao();
    wxStationDao.save(arg);
  }

  public WxStationList selectAllAirports() {
    WxStationDao wxStationDao = new WxStationDao();
    return wxStationDao.selectAllAirports();
  }

  public void save(WxObservation arg) {
    WxObservationDao wxObservationDao = new WxObservationDao();
    wxObservationDao.save(arg);
  }

  public WxObservation selectObservation(final String airport, final Date timeStamp) {
    WxObservationDao wxObservationDao = new WxObservationDao();
    return wxObservationDao.selectOne(airport, timeStamp);
  }

  ////////////////
  //// lotto
  ////////////////

  public void save(Daily3 arg) {
    Daily3Dao daily3Dao = new Daily3Dao();
    daily3Dao.save(arg);
  }

  public Daily3 selectDaily3(long draw) {
    Daily3Dao daily3Dao = new Daily3Dao();
    return daily3Dao.selectOne(draw);
  }

  public void save(Daily4 arg) {
    Daily4Dao daily4Dao = new Daily4Dao();
    daily4Dao.save(arg);
  }

  public Daily4 selectDaily4(long draw) {
    Daily4Dao daily4Dao = new Daily4Dao();
    return daily4Dao.selectOne(draw);
  }

  public void save(Fantasy5 arg) {
    Fantasy5Dao fantasy5Dao = new Fantasy5Dao();
    fantasy5Dao.save(arg);
  }

  public Fantasy5 selectFantasy5(long draw) {
    Fantasy5Dao fantasy5Dao = new Fantasy5Dao();
    return fantasy5Dao.selectOne(draw);
  }

  public void save(MegaMillion arg) {
    MegaMillionDao megaMillionDao = new MegaMillionDao();
    megaMillionDao.save(arg);
  }

  public MegaMillion selectMegaMillion(long draw) {
    MegaMillionDao megaMillionDao = new MegaMillionDao();
    return megaMillionDao.selectOne(draw);
  }

  public void save(PowerBall arg) {
    PowerBallDao powerBallDao = new PowerBallDao();
    powerBallDao.save(arg);
  }

  public PowerBall selectPowerBall(long draw) {
    PowerBallDao powerBallDao = new PowerBallDao();
    return powerBallDao.selectOne(draw);
  }

  public void save(SuperLotto arg) {
    SuperLottoDao superLottoDao = new SuperLottoDao();
    superLottoDao.save(arg);
  }

  public SuperLotto selectSuperLotto(long draw) {
    SuperLottoDao superLottoDao = new SuperLottoDao();
    return superLottoDao.selectOne(draw);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 27, 2014 by gsc
 */