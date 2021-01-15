package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;

public abstract class FeefoApiGetRequest<R> extends AbstractFeefoApiRequest<R> {

  public FeefoApiGetRequest(TypeReference<R> responseTypeReference) {
    super(responseTypeReference);
  }

  @Override
  public void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception {
    connection.setRequestMethod("GET");
  }

}
