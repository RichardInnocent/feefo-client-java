package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.FeefoApiClient;

public class NoSessionAuthenticationProvider implements AuthenticationProvider {

  @Override
  public String getAuthenticationToken(FeefoApiClient apiClient) {
    return null;
  }
}
