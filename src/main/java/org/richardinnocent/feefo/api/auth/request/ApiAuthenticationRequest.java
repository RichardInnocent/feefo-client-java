package org.richardinnocent.feefo.api.auth.request;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.richardinnocent.feefo.api.auth.ApiCredentials;
import org.richardinnocent.feefo.api.requests.FeefoApiPostRequest;
import org.richardinnocent.feefo.api.requests.QueryParameter;

/**
 * Request that is used to authenticate the user and receive a valid authentication header that can
 * then be used to authenticate subsequent requests if required. The authentication is valid for a
 * merchant and (most likely) all of its sub-merchants. The authentication process requires four
 * pieces of information, namely:
 * <ul>
 *   <li><b>Merchant identifier</b>: The unique identifier for the merchant.</li>
 *   <li><b>API key</b>: The API for the given merchant.</li>
 *   <li><b>Username</b>: The username (probably the email address) for a merchant admin user tied
 *   to the specified account. Feefo recommends adding a dedicated user account specifically to be
 *   used to authenticate API requests.</li>
 *   <li><b>Password</b>: The password for the aforementioned user.</li>
 * </ul>
 * More details can be found on the
 * <a href="https://support.feefo.com/support/solutions/articles/8000041717-api-authentication">API documentation page</a>.
 */
public class ApiAuthenticationRequest extends
    FeefoApiPostRequest<Map<String, ApiAuthenticationRequestDto>, ApiAuthenticationResponse> {

  private static final TypeReference<ApiAuthenticationResponse> RESPONSE_TYPE_REFERENCE =
      new TypeReference<ApiAuthenticationResponse>() {};

  /**
   * Creates a new request that attempts to retrieve an authorization token from the Feefo API that
   * can then be used to authorize subsequent requests.
   * @param credentials The credentials required to generate the authorization token.
   * @throws NullPointerException Thrown if {@code credentials == null}.
   * @see ApiAuthenticationRequest
   */
  public ApiAuthenticationRequest(ApiCredentials credentials) throws NullPointerException {
    super(
        Collections.singletonMap("authenticationDTO", toDto(credentials)), RESPONSE_TYPE_REFERENCE
    );
  }

  private static ApiAuthenticationRequestDto toDto(ApiCredentials credentials) {
    Objects.requireNonNull(credentials, "Credentials must be provided to generate a token");
    ApiAuthenticationRequestDto dto = new ApiAuthenticationRequestDto();
    dto.setMerchantIdentifier(credentials.getMerchantIdentifier());
    dto.setApiKey(credentials.getApiKey());
    dto.setUsername(credentials.getUsername());
    dto.setPassword(credentials.getPassword());
    return dto;
  }

  @Override
  protected String getBasePath() {
    return "/apiauthenticate";
  }

  @Override
  protected Collection<QueryParameter> getQueryParameters() {
    return Collections.emptyList();
  }

  @Override
  public boolean requiresAuthentication() {
    return false;
  }

}
