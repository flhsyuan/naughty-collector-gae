package com.digiburo.naughty.collector.datastore.dao;

import com.digiburo.naughty.collector.TestHelper;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by gsc on 6/5/14.
 */
public class ReceiptDaoTest {
  private final TestHelper testHelper = new TestHelper();

  private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

  @Before
  public void setUp() {
    helper.setUp();
  }

  @After
  public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void testSave() {
    String address = testHelper.randomString();
    String messageType = testHelper.randomString();
    String note = testHelper.randomString();

    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(address, messageType, note);
    assertNotNull(receipt);
  }
}
