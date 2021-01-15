package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public abstract class FeefoApiPostRequest<B, R> extends AbstractFeefoApiRequest<R> {

  private final B requestBody;

  protected FeefoApiPostRequest(B requestBody, TypeReference<R> responseTypeReference) {
    super(responseTypeReference);
    this.requestBody = requestBody;
  }

  @Override
  public void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception {
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Accept", "application/json");
    connection.setRequestProperty("Content-Type", "application/json; utf-8");
    connection.setDoOutput(true);
    String content = objectMapper.writeValueAsString(requestBody);

    try (OutputStream outputStream = connection.getOutputStream()) {
      outputStream.write(content.getBytes(StandardCharsets.UTF_8));
    }
  }


}
