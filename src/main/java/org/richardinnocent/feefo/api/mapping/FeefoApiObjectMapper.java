package org.richardinnocent.feefo.api.mapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Mapper for serialising/deserialising Feefo API requests and responses.
 */
public class FeefoApiObjectMapper extends ObjectMapper {

  /**
   * Creates a new mapper for serialising/deserialising Feefo API requests and responses.
   */
  public FeefoApiObjectMapper() {
    registerModule(FeefoTimeModule.getInstance());
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

}
