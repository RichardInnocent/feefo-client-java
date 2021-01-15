package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;

public interface FeefoApiRequest<R> {

  /**
   * Gets the full URL path.
   * @return The full URL path.
   */
  String getPath();

  /**
   * Configures the connection as appropriate. The implementation can add headers, a request body
   * etc.
   * @param connection The connection that will be used to send the request.
   * @param objectMapper The mapper that should be used if objects should be converted into JSON.
   * This should be used when, for example, generating a POST body from an object.
   * @throws Exception Thrown if there is a problem configuring the connection.
   */
  void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception;

  /**
   * Gets the object type that is expected to be returned from a successful call to the API.
   * @return The object type that is expected to be returned from a successful call to the API.
   */
  TypeReference<R> getResponseTypeReference();

  /**
   * Does this request require an authentication header?
   * @return {@code true} if this request requires an authentication header.
   */
  boolean requiresAuthentication();

  /**
   * If the request fails with an unauthorised response code, should the authentication token be
   * refreshed and the request re-attempted once?
   * @return {@code true} if the authorization token should be refreshed and the request
   * re-attempted once if an unauthorized response is received from the Feefo API.
   */
  boolean refreshAuthenticationAndRetryIfUnauthorised();

}
