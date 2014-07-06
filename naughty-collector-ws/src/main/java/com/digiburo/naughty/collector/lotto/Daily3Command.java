package com.digiburo.naughty.collector.lotto;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.Daily3;
import com.digiburo.naughty.collector.utility.CalDate;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;

import java.util.logging.Logger;

/**
 * Created by gsc on 7/5/14.
 */
public class Daily3Command extends AbstractLottoCommand {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  private Daily3 lineParser(final String raw) {
    Character char0 = new Character(raw.charAt(0));
    if (!Character.isDigit(char0)) {
      return null;
    }

    String[] buffer = raw.split(" ");
    for (int ii = 0; ii < buffer.length; ii++) {
//      System.out.println(ii + ":" + buffer[ii]);
    }

    String month = null;
    int monthDay = 0;

    Daily3 result = new Daily3();

    int token = 0;
    for (int ii = 0; ii < buffer.length; ii++) {
      if (buffer[ii].isEmpty()) {
        //empty
      } else {
//        System.out.println(ii + ":" + buffer[ii]);
        switch(token) {
          case 0:
            ++token;
            result.setDraw(Long.parseLong(buffer[ii]));
            break;
          case 1:
            ++token;
            String weekDay = buffer[ii];
            break;
          case 2:
            ++token;
            month = buffer[ii];
            break;
          case 3:
            ++token;
            String temp;
            if (buffer[ii].endsWith(",")) {
              temp = buffer[ii].replace(",", " ").trim();
            } else {
              temp = buffer[ii];
            }
            monthDay = Integer.parseInt(temp);
            break;
          case 4:
            ++token;
            int year = Integer.parseInt(buffer[ii]);
            CalDate calDate = new CalDate(year, monthConverter(month), monthDay);
            result.setDate(calDate.getDateValue());
            break;
          case 5:
            ++token;
            result.setValue1(Long.parseLong(buffer[ii]));
            break;
          case 6:
            ++token;
            result.setValue2(Long.parseLong(buffer[ii]));
            break;
          case 7:
            ++token;
            result.setValue3(Long.parseLong(buffer[ii]));
            break;
        }
      }
    }

    return result;
  }

  private void rawParser(final String raw) {
    String[] buffer = raw.split("\n");
//    System.out.println("lines:" + buffer.length);

    int success = 0;

    for (int ii = 0; ii < buffer.length; ii++) {
      Daily3 daily3 = lineParser(buffer[ii]);
//      System.out.println(daily3);
      if (daily3 != null) {
        Daily3 selected = dataBaseFacade.selectDaily3(daily3.getDraw());
        if (selected == null) {
          ++success;
          dataBaseFacade.save(daily3);
        }
      }
    }

    dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "Daily3 load summary:" + buffer.length + ":" + success);
  }

  public void execute() {
    String raw = fetcher(DAILY3_URL);
    if (!raw.isEmpty()) {
      rawParser(raw);
    }
  }
}
