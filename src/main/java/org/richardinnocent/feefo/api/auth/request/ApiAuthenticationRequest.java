package org.richardinnocent.feefo.api.auth.request;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;
import org.richardinnocent.feefo.api.requests.FeefoApiPostRequest;

public class ApiAuthenticationRequest extends
    FeefoApiPostRequest<Map<String, AuthenticationDto>, ApiAuthenticationResponse> {

  private static final TypeReference<ApiAuthenticationResponse> RESPONSE_TYPE_REFERENCE =
      new TypeReference<ApiAuthenticationResponse>() {};

  public ApiAuthenticationRequest(AuthenticationDto authenticationDto) {
    super(
        Collections.singletonMap("authenticationDTO", authenticationDto), RESPONSE_TYPE_REFERENCE
    );
  }

  @Override
  public String getPath() {
    return "apiauthenticate";
  }

  @Override
  public boolean isVersioned() {
    return false;
  }

  @Override
  public boolean requiresAuthentication() {
    return false;
  }
}
