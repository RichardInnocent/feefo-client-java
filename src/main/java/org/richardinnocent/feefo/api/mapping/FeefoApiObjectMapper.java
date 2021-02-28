package org.richardinnocent.feefo.api.mapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.richardinnocent.feefo.api.mapping.modules.time.FeefoTimeModule;

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
    enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
  }

}
