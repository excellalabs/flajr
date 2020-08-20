package com.excella.flajr;

import com.excella.flajr.domain.Flag;
import feign.AsyncFeign;
import feign.Feign;
import feign.Logger;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FlagrClientAsync {

  @RequestLine("GET /flags")
  CompletableFuture<List<Flag>> getAllFlags();

  static FlagrClientAsync create(String url) {
    return AsyncFeign.asyncBuilder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logger(new Logger.ErrorLogger())
        .target(FlagrClientAsync.class, url);
  }
}
