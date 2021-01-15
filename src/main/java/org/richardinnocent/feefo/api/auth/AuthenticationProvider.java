package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.client.FeefoApiClient;

public interface AuthenticationProvider {

  String getAuthenticationToken(FeefoApiClient apiClient);

}
