package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.client.FeefoApiClient;

/**
 * Provides an authentication token when required.
 */
public interface AuthenticationProvider {

  /**
   * Returns a valid authentication token, or {@code null} if an authentication token should not be
   * generated.
   * @param apiClient The Feefo API client. This is used if the API is used to generate the token.
   * @return A valid authentication token, or {@code null}.
   */
  String getAuthenticationToken(FeefoApiClient apiClient);

}
