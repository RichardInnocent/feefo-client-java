package org.richardinnocent.feefo.api.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FeefoApiObjectMapper extends ObjectMapper {

  public FeefoApiObjectMapper() {
    registerModule(FeefoTimeModule.getInstance());
  }

}
