package com.excella.flajr;

import com.excella.flajr.domain.Flag;
import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.List;

interface FeignFlagrClient {

  @RequestLine("GET /flags")
  List<Flag> getAllFlags();

  @RequestLine("GET /flags/{id}")
  Flag getFlag(@Param("id") Integer id);

  static FeignFlagrClient create(String url) {
    return Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logger(new Logger.ErrorLogger())
        .target(FeignFlagrClient.class, url);
  }
}
