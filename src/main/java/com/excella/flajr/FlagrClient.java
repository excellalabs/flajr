package com.excella.flajr;

import com.excella.flajr.domain.Flag;
import feign.Feign;
import feign.Logger;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.List;

public interface FlagrClient {

  @RequestLine("GET /flags")
  List<Flag> getAllFlags();

  static FlagrClient create(String url) {
    return Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logger(new Logger.ErrorLogger())
        .target(FlagrClient.class, url);
  }
}
