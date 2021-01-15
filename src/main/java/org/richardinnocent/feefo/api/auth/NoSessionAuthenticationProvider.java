package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.client.FeefoApiClient;

/**
 * Only some parts of the Feefo API require authentication. If these parts of the API are not used,
 * there's no need to generate an authentication token. In that case, this class can be passed to
 * the {@link FeefoApiClient}.
 */
public class NoSessionAuthenticationProvider implements AuthenticationProvider {

  private static final NoSessionAuthenticationProvider INSTANCE =
      new NoSessionAuthenticationProvider();

  /**
   * Gets the singleton instance of the {@link NoSessionAuthenticationProvider}.
   * @return The singleton instance.
   */
  public static NoSessionAuthenticationProvider getInstance() {
    return INSTANCE;
  }

  // Singleton as this has no state
  private NoSessionAuthenticationProvider() {}

  @Override
  public String getAuthorizationToken(FeefoApiClient apiClient) {
    return null;
  }
}
