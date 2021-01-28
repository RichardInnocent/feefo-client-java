package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Abstraction implementation of a POST request to the Feefo API.
 * @param <B> The object type for the request body.
 * @param <R> The object type for the response.
 */
public abstract class FeefoApiPostRequest<B, R> extends AbstractFeefoApiRequest<R> {

  private final B requestBody;

  /**
   * Creates a new POST request.
   * @param requestBody The request body that should be sent in the payload of the request.
   * @param responseTypeReference The type reference of the response.
   * @throws NullPointerException Thrown if {@code responseTypeReference == null}.
   */
  protected FeefoApiPostRequest(B requestBody, TypeReference<R> responseTypeReference)
      throws NullPointerException {
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
