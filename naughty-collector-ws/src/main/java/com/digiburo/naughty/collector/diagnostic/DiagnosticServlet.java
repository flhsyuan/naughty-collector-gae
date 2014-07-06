package com.digiburo.naughty.collector.diagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * simple diagnostic servlet
 *
 * @author gsc
 */
public class DiagnosticServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    logger.log(Level.INFO, "diagnostic doGet:" + request.getRemoteAddr());
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    environmentDump(request, pw);
    pw.close();
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    logger.log(Level.INFO, "diagnostic doPost:" + request.getRemoteAddr());

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));

    String line = null;
    StringBuffer sb = new StringBuffer();
    while ((line = bufferedReader.readLine()) != null) {
      sb.append(line);
    }

    logger.log(Level.INFO, sb.toString());

    response.setContentType("application/json");
    PrintWriter pw = response.getWriter();
    pw.println("{\"receipt\":\"b4891705-c3dd-46da-927c-1fda565b76a2\",\"sortieId\":\"efgh\",\"status\":\"OK\",\"timeStamp\":\"2014-05-22T21:56:55Z\",\"messageVersion\":1,\"rowCount\":2,\"remoteIpAddress\":\"127.0.0.1\",\"_links\":{\"self\":{\"href\":\"http://127.0.0.1:8080/ws1/v1/location\"}}}");
    pw.close();
  }

  /*
  * Connection #0 to host 127.0.0.1 left intact
{"receipt":"b4891705-c3dd-46da-927c-1fda565b76a2","sortieId":"efgh","status":"OK","timeStamp":"2014-05-22T21:56:55Z","messageVersion":1,"rowCount":2,"remoteIpAddress":"127.0.0.1","_links":{"self":{"href":"http://127.0.0.1:8080/ws1/v1/location"}}}gsc@duckman:67>

   */

  @SuppressWarnings("unchecked")
  private void environmentDump(HttpServletRequest request, PrintWriter pw) {
    pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">");
    pw.println("<html>");
    pw.println("  <head><title>Diagnostic Servlet</title></head>");
    pw.println("  <body>");
    pw.println("    Welcome:" + request.getRemoteAddr() + "<br>");
    pw.println("    <table border=5 align=center>");
    pw.println("    <tr><th>param name<th>value");
    
    Enumeration<String> paramz = request.getParameterNames();
    while (paramz.hasMoreElements()) {
      String name = (String) paramz.nextElement();
      String[] valuez = null;
      try {
        valuez = request.getParameterValues(name);
      } catch(Exception exception) {
        valuez = new String[1];
        valuez[0] = "exception";
      }
      
      pw.println("    <tr><td>" + name + "<td>" + valuez.length + "//");
      if (valuez.length > 0) {
        pw.println(valuez[0]);
      } else {
        pw.println("No Value");
      }
    }

    pw.println("</table>");
    
    ///////////////////////
    
    pw.println("    <table border=5 align=center>");
    pw.println("    <tr><th>attribute name<th>value");
    
    Enumeration<String> attributez = request.getAttributeNames();
    while (attributez.hasMoreElements()) {
      String name = (String) attributez.nextElement();
      String value = null;
      try {
        value = (String) request.getAttribute(name);
      } catch(Exception exception) {
        value = "exception";
      }
      
      pw.println("    <tr><td>" + name + "<td>" + value);
    }

    pw.println("</table>");
    
    ///////////////////////
    
    pw.println("    <table border=5 align=center>");
    pw.println("    <tr><th>header name<th>value");

    Enumeration<String> headerz = request.getHeaderNames();
    while (headerz.hasMoreElements()) {
      String name = (String) headerz.nextElement();
      String value = null;
      try {
        value = request.getHeader(name);
      } catch(Exception exception) {
        value = "exception";
      }
      
      pw.println("    <tr><td>" + name + "<td>" + value);
    }

    pw.println("</table>");
    pw.println("</body>");
    pw.println("</html>");
  }

  //
  private static final long serialVersionUID = -2283886794458257441L;

  //
  private final Logger logger = Logger.getLogger(getClass().getName());
}

/*
 * Copyright 2012 Digital Burro, INC
 * Created on Sep 7, 2012 by gsc
 */