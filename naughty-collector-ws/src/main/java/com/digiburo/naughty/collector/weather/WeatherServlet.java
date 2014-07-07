package com.digiburo.naughty.collector.weather;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class WeatherServlet extends HttpServlet {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private final WeatherHelper weatherHelper = new WeatherHelper();

  private void response(HttpServletRequest request, PrintWriter pw) {
    pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4loose.dtd\">");
    pw.println("<html>");
    pw.println("  <head><title>Command Servlet</title></head>");
    pw.println("  <body>");
    pw.println("    Welcome:" + request.getRemoteAddr() + "<br>");
    pw.println("  </body>");
    pw.println("</html>");
    pw.close();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    logger.info("command doGet:" + request.getRemoteAddr());

    if (request.getRemoteAddr().equals("0.1.0.1")) {
      weatherHelper.execute();
    } else {
      logger.info("skipping invocation, bad remote address");
    }

    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    response(request, pw);
    pw.close();
  }
}