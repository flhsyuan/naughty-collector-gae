package com.digiburo.naughty.collector.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * RFC 3339 date formatter "2014-04-05T03:51:17Z"
 * @author gsc
 */
@Component
public class Rfc3339DateSerializer extends JsonSerializer<Date> {
  @Override
  public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException, JsonProcessingException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    String formattedDate = sdf.format(value);
    jsonGenerator.writeString(formattedDate);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on June 28, 2014 by gsc
 */
