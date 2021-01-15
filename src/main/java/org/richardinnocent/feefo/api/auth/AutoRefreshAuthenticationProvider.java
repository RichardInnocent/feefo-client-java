package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.FeefoApiClient;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationRequest;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationResponse;
import org.richardinnocent.feefo.api.auth.request.AuthenticationDto;

public class AutoRefreshAuthenticationProvider implements AuthenticationProvider {

  private final String merchantIdentifier;
  private final String username;
  private final String password;
  private final String apiKey;

  private AuthenticationToken currentToken;

  public AutoRefreshAuthenticationProvider(String merchantIdentifier, String username, String password, String apiKey) {
    this.merchantIdentifier = ensureNotEmpty(merchantIdentifier, "Merchant identifier");
    this.username = ensureNotEmpty(username, "Username");
    this.password = ensureNotEmpty(password, "Password");
    this.apiKey = ensureNotEmpty(apiKey, "API key");
  }

  private String ensureNotEmpty(String input, String variableName) {
    if (input == null) {
      throw new NullPointerException(variableName + " cannot be null");
    }
    if (input.isEmpty()) {
      throw new IllegalArgumentException(variableName + " cannot be empty");
    }
    return input;
  }

  @Override
  public synchronized String getAuthenticationToken(FeefoApiClient apiClient) {
    if (currentToken == null || currentToken.hasExpired()) {
      this.currentToken = generateAuthenticationToken(apiClient);
    }
    return currentToken.getToken();
  }

  private AuthenticationToken generateAuthenticationToken(FeefoApiClient apiClient) {
    AuthenticationDto authenticationDto = new AuthenticationDto();
    authenticationDto.setMerchantIdentifier(merchantIdentifier);
    authenticationDto.setUsername(username);
    authenticationDto.setPassword(password);
    authenticationDto.setApiKey(apiKey);
    ApiAuthenticationRequest request = new ApiAuthenticationRequest(authenticationDto);
    ApiAuthenticationResponse response = apiClient.execute(request);
    return toToken(response);
  }

  private AuthenticationToken toToken(ApiAuthenticationResponse response) {
    return AuthenticationToken.of(response.getApiToken(), response.getExpiresTime());
  }
}
