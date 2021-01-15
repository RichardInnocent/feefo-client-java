package org.richardinnocent.feefo.api.auth;

import org.richardinnocent.feefo.api.FeefoApiClient;

public interface AuthenticationProvider {

  String getAuthenticationToken(FeefoApiClient apiClient);

}
