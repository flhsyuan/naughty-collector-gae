package com.digiburo.naughty.collector.lotto;

import java.util.logging.Logger;

/**
 * Created by gsc on 7/5/14.
 */
public class Daily4 extends AbstractLottoCommand {
  private final Logger logger = Logger.getLogger(getClass().getName());

  public void lineParser(final String raw) {
    System.out.println(raw);

    Character char0 = new Character(raw.charAt(0));
    if (!Character.isDigit(char0)) {
      return;
    }

    String[] buffer = raw.split(" ");
    for (int ii = 0; ii < buffer.length; ii++) {
//      System.out.println(ii + ":" + buffer[ii]);
    }

    int token = 0;
    for (int ii = 0; ii < buffer.length; ii++) {
      if (buffer[ii].isEmpty()) {

      } else {
        System.out.println(ii + ":" + buffer[ii]);
        switch(token) {
          case 0:
            ++token;
            int event = Integer.parseInt(buffer[ii]);
            break;
          case 1:
            ++token;
            String weekDay = buffer[ii];
            break;
          case 2:
            ++token;
            String month = buffer[ii];
            break;
          case 3:
            ++token;
            String temp;
            if (buffer[ii].endsWith(",")) {
              temp = buffer[ii].replace(",", " ").trim();
            } else {
              temp = buffer[ii];
            }
            int monthDay = Integer.parseInt(temp);
            break;
          case 4:
            ++token;
            int year = Integer.parseInt(buffer[ii]);
            break;
          case 5:
            ++token;
            int draw1 = Integer.parseInt(buffer[ii]);
            break;
          case 6:
            ++token;
            int draw2 = Integer.parseInt(buffer[ii]);
            break;
          case 7:
            ++token;
            int draw3 = Integer.parseInt(buffer[ii]);
            break;
          case 8:
            ++token;
            int draw4 = Integer.parseInt(buffer[ii]);
            break;
        }
      }
    }
  }

  public void rawParser(final String raw) {
    String[] buffer = raw.split("\n");
    System.out.println("lines:" + buffer.length);
    for (int ii = 0; ii < buffer.length; ii++) {
      lineParser(buffer[ii]);
    }
  }

  public void execute() {
    String raw = fetcher(DAILY4_URL);
    if (!raw.isEmpty()) {
      rawParser(raw);
    }
  }
}
