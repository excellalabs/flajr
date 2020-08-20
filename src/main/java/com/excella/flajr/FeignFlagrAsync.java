package com.excella.flajr;

import com.excella.flajr.domain.Flag;
import feign.AsyncFeign;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FeignFlagrAsync {

  @RequestLine("GET /flags")
  CompletableFuture<List<Flag>> getAllFlags();

  @RequestLine("GET /flags/{id}")
  CompletableFuture<Flag> getFlag(@Param("id") Integer id);

  static FeignFlagrAsync create(String url) {
    return AsyncFeign.asyncBuilder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logger(new Logger.ErrorLogger())
        .target(FeignFlagrAsync.class, url);
  }
}
