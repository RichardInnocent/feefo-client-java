package org.richardinnocent.feefo.api.client;

import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;
import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

/**
 * The client that interacts with the Feefo API.
 */
public interface FeefoApiClient {

  /**
   * Gets the base URL for the Feefo API.
   * @return The base URL for the Feefo API.
   */
  String getBaseUrl();

  /**
   * Executes the specified request and returns the result. If
   * {@link FeefoApiRequest#requiresAuthentication()} returns {@code true}, the authorization header
   * will be added to the request, retrieved from the configured
   * {@link org.richardinnocent.feefo.api.auth.AuthenticationProvider}.
   * @param request The request to execute.
   * @param <R> The type of object returned from the request.
   * @return The result of the request.
   * @throws FeefoApiRequestFailedException Thrown if there is a problem executing the request. This
   * could mean that the configuration of the request is invalid and was therefore never sent, or
   * that the API responded with a non-2xx return code.
   */
  <R> R execute(FeefoApiRequest<R> request) throws FeefoApiRequestFailedException;
}
