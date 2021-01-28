package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;

/**
 * Abstract implementation of a GET request to be sent to the Feefo API.
 * @param <R> The response type.
 */
public abstract class FeefoApiGetRequest<R> extends AbstractFeefoApiRequest<R> {

  /**
   * Creates a new GET request.
   * @param responseTypeReference The type reference of the response.
   * @throws NullPointerException Thrown if {@code responseTypeReference == null}.
   */
  public FeefoApiGetRequest(TypeReference<R> responseTypeReference) throws NullPointerException {
    super(responseTypeReference);
  }

  @Override
  public void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception {
    connection.setRequestMethod("GET");
  }

}
