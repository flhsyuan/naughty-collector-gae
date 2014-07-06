package com.digiburo.naughty.collector.datastore.entity;

import com.digiburo.naughty.collector.TestHelper;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gsc on 6/4/14.
 */
public class ReceiptTest {
  private final TestHelper testHelper = new TestHelper();

  @Test
  public void testDefault() {
    Receipt receipt = new Receipt();

    assertNotNull(receipt.getTimeStamp());

    assertTrue(Receipt.DEFAULT_ADDRESS.equals(receipt.getIpAddress()));
    assertTrue(Receipt.DEFAULT_MESSAGE_TYPE.equals(receipt.getMessageType()));
    assertTrue(Receipt.DEFAULT_UUID.equals(receipt.getReceiptUuid()));
    assertTrue(Receipt.DEFAULT_NOTE.equals(receipt.getNote()));
  }

  @Test
  public void receiptUuidTest() {
    String target = testHelper.randomString();

    Receipt receipt = new Receipt();
    receipt.setReceiptUuid(target);
    assertTrue(target.equals(receipt.getReceiptUuid()));
  }

  @Test(expected=NullPointerException.class)
  public void nullReceiptUuidTest() {
    Receipt receipt = new Receipt();
    receipt.setReceiptUuid(null);
  }

  @Test
  public void addressTest() {
    String target = testHelper.randomString();

    Receipt receipt = new Receipt();
    receipt.setIpAddress(target);
    assertTrue(target.equals(receipt.getIpAddress()));
  }

  @Test(expected=NullPointerException.class)
  public void nullAddressTest() {
    Receipt receipt = new Receipt();
    receipt.setIpAddress(null);
  }

  @Test
  public void messageTypeTest() {
    String target = testHelper.randomString();

    Receipt receipt = new Receipt();
    receipt.setMessageType(target);
    assertTrue(target.equals(receipt.getMessageType()));
  }

  @Test(expected=NullPointerException.class)
  public void nullMessageTypeTest() {
    Receipt receipt = new Receipt();
    receipt.setMessageType(null);
  }

  @Test
  public void noteTest() {
    String target = testHelper.randomString();

    Receipt receipt = new Receipt();
    receipt.setNote(target);
    assertTrue(target.equals(receipt.getNote()));
  }

  @Test(expected=NullPointerException.class)
  public void nullNoteTest() {
    Receipt receipt = new Receipt();
    receipt.setNote(null);
  }

  @Test
  public void timeTest() {
    Date date = new Date();

    Receipt receipt = new Receipt();
    receipt.setTimeStamp(date);
    assertTrue(date.equals(receipt.getTimeStamp()));
  }

  @Test(expected=NullPointerException.class)
  public void nullTimeTest() {
    Receipt receipt = new Receipt();
    receipt.setTimeStamp(null);
  }
}
