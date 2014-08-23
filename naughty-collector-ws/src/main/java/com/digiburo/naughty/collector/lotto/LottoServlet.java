package com.digiburo.naughty.collector.lotto;

import com.digiburo.naughty.collector.datastore.DataBaseFacade;
import com.digiburo.naughty.collector.utility.LogFacility;
import com.digiburo.naughty.collector.utility.LogPriority;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

public class LottoServlet extends HttpServlet {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private final DataBaseFacade dataBaseFacade = new DataBaseFacade();

  private static final String EMPTY_VALUE = "emptyValue";
  private static final String EXCEPTION_NOTED = "exceptionNoted";
  private static final String PARAMETER_STUNT = "stunt";

  private LottoCommand serviceStunt(HttpServletRequest request) {
    LottoCommand result = LottoCommand.UNKNOWN;

    @SuppressWarnings("unchecked")
    Enumeration<String> paramz = request.getParameterNames();
    while (paramz.hasMoreElements()) {
      String name = (String) paramz.nextElement();
      String[] valuez = null;

      try {
        valuez = request.getParameterValues(name);
      } catch(Exception exception) {
        valuez = new String[1];
        valuez[0] = EXCEPTION_NOTED;
      }

      if (valuez == null) {
        valuez = new String[1];
        valuez[0] = EMPTY_VALUE;
      }

      if (name.equals(PARAMETER_STUNT)) {
        result = LottoCommand.discoverMatchingEnum(valuez[0]);
        if (result == LottoCommand.UNKNOWN) {
          logger.warning("unknown stunt value:" + valuez.length + ":" + valuez[0]);
        }
      } else {
        logger.warning("unknown parameter:" + name + ":value:" + valuez.length);
      }
    }

    return(result);
  }

  private void response(HttpServletRequest request, PrintWriter pw, LottoCommand command) {
    pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4loose.dtd\">");
    pw.println("<html>");
    pw.println("  <head><title>Command Servlet</title></head>");
    pw.println("  <body>");
    pw.println("    Welcome:" + request.getRemoteAddr() + "<br>");
    pw.println("    Command:" + command.toString() + "<br>");
    pw.println("  </body>");
    pw.println("</html>");
    pw.close();
  }

  public void workFlow(final LottoCommand commandType) {
    logger.info("workFlow:" + commandType);

    AbstractLottoCommand commandHelper = null;

    switch (commandType) {
      case DAILY3:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect Daily3");
        commandHelper = new Daily3Command();
        break;
      case DAILY4:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect Daily4");
        commandHelper = new Daily4Command();
        break;
      case FANTASY5:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect Fantasy5");
        commandHelper = new Fantasy5Command();
        break;
      case MEGA_MILLION:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect MegaMillion");
        commandHelper = new MegaMillionCommand();
        break;
      case POWER_BALL:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect PowerBall");
        commandHelper = new PowerBallCommand();
        break;
      case SUPER_LOTTO:
        dataBaseFacade.writeLog(LogFacility.LOTTO, LogPriority.INFO, "collect SuperLotto");
        commandHelper = new SuperLottoCommand();
        break;
      default:
        logger.info("unsupported command type:" + commandType);
        return;
    }

    commandHelper.execute();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    logger.info("command doGet:" + request.getRemoteAddr());

    LottoCommand command = LottoCommand.UNKNOWN;
    if ((request.getRemoteAddr().equals("0.1.0.1")) || (request.getRemoteAddr().equals("127.0.0.1"))) {
      command = serviceStunt(request);
      //lottery now handled by jaded nomad
      //workFlow(command);
    } else {
      logger.info("skipping invocation, bad remote address");
    }

    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    response(request, pw, command);
    pw.close();
  }
}