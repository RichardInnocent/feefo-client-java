package org.richardinnocent.feefo.api.auth;

import java.util.Objects;
import org.richardinnocent.feefo.api.client.FeefoApiClient;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationRequest;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationResponse;

/**
 * An authentication provider that can generate a token on demand. Once a token has been generated,
 * it is kept in memory until the token expires. On a subsequent call, a new authentication token
 * will be retrieved.
 */
public class AutoRefreshAuthenticationProvider implements AuthenticationProvider {

  private final ApiCredentials credentials;

  private AuthenticationToken currentToken;

  public AutoRefreshAuthenticationProvider(ApiCredentials credentials)
      throws NullPointerException {
    this.credentials = Objects.requireNonNull(credentials, "Credentials must be specified");
  }

  @Override
  public synchronized String getAuthorizationToken(FeefoApiClient apiClient) {
    if (currentToken == null || currentToken.hasExpired()) {
      this.currentToken = generateAuthenticationToken(apiClient);
    }
    return currentToken.getToken();
  }

  private AuthenticationToken generateAuthenticationToken(FeefoApiClient apiClient) {
    return toToken(apiClient.execute(new ApiAuthenticationRequest(credentials)));
  }

  private AuthenticationToken toToken(ApiAuthenticationResponse response) {
    return AuthenticationToken.of(response.getApiToken(), response.getExpiresTime());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AutoRefreshAuthenticationProvider that = (AutoRefreshAuthenticationProvider) o;
    return Objects.equals(credentials, that.credentials) && Objects
        .equals(currentToken, that.currentToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credentials, currentToken);
  }
}
