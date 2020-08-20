package com.excella.flajr;

import com.excella.flajr.domain.Flag;
import feign.FeignException;

import java.util.List;
import java.util.Optional;

public class Flagr {

  private final FeignFlagrClient feignFlagrClient;

  public Flagr(String url) {
    this.feignFlagrClient = FeignFlagrClient.create(url);
  }

  public List<Flag> getAllFlags() {
    return feignFlagrClient.getAllFlags();
  }

  /*
    Wraps the flag in an Optional for null safety. A 404 response means the flag does not exist
     or flagr is down. Either way, no flag, respond with empty optional.
     Any other HTTP Response Code error is thrown.
   */
  public Optional<Flag> getFlag(Integer id) {
    try {
      Flag flag = feignFlagrClient.getFlag(id);
      return Optional.ofNullable(flag);
    } catch (FeignException.NotFound e) {
      return Optional.empty();
    }
  }
}
