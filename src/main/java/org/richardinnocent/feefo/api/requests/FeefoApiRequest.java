package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;

public interface FeefoApiRequest<R> {

  String getPath();
  void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception;
  TypeReference<R> getResponseTypeReference();
  boolean isVersioned();
  boolean requiresAuthentication();

}
