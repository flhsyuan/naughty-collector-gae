package com.digiburo.naughty.collector.lotto;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.datastore.entity.MegaMillion;
import com.digiburo.naughty.collector.utility.CalDate;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;

import java.util.logging.Logger;

/**
 * Created by gsc on 7/5/14.
 */
public class MegaMillionCommand extends AbstractLottoCommand {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  private MegaMillion lineParser(final String raw) {
//    System.out.println(raw);

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

    MegaMillion result = new MegaMillion();

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
          case 8:
            ++token;
            result.setValue4(Long.parseLong(buffer[ii]));
            break;
          case 9:
            ++token;
            result.setValue5(Long.parseLong(buffer[ii]));
            break;
          case 10:
            ++token;
            result.setMega(Long.parseLong(buffer[ii]));
            break;
        }
      }
    }

    return result;
  }

  public void rawParser(final String raw) {
    String[] buffer = raw.split("\n");
//    System.out.println("lines:" + buffer.length);

    int success = 0;

    for (int ii = 0; ii < buffer.length; ii++) {
      MegaMillion megaMillion = lineParser(buffer[ii]);
//      System.out.println(megaMillion);
      if (megaMillion != null) {
        MegaMillion selected = dataBaseFacade.selectMegaMillion(megaMillion.getDraw());
        if (selected == null) {
          ++success;
          dataBaseFacade.save(megaMillion);
        }
      }
    }

    dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "MegaMillion load summary:" + buffer.length + ":" + success);
  }

  public void execute() {
    String raw = fetcher(MEGA_MILLION_URL);
    if (!raw.isEmpty()) {
      rawParser(raw);
    }
  }
}
