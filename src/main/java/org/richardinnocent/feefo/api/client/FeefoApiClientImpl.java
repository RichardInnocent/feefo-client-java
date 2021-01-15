package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.util.Objects;
import javax.naming.AuthenticationException;
import org.richardinnocent.feefo.api.auth.AuthenticationProvider;
import org.richardinnocent.feefo.api.auth.NoSessionAuthenticationProvider;
import org.richardinnocent.feefo.api.mapping.FeefoApiObjectMapper;

public class FeefoApiClientImpl extends AbstractFeefoApiClient {

  private static final String DEFAULT_BASE_URL = "https://api.feefo.com/api";

  private final AuthenticationProvider authenticationProvider;
  private final ObjectMapper objectMapper;

  @Override
  protected ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  public FeefoApiClientImpl() {
    this(DEFAULT_BASE_URL, null, null);
  }

  public FeefoApiClientImpl(AuthenticationProvider authenticationProvider) {
    this(DEFAULT_BASE_URL, authenticationProvider, new FeefoApiObjectMapper());
  }

  public FeefoApiClientImpl(
      String baseUrl, AuthenticationProvider authenticationProvider, ObjectMapper objectMapper) {
    super(baseUrl);
    this.objectMapper = Objects.requireNonNull(objectMapper, "Object mapper is null");
    this.authenticationProvider = authenticationProvider == null ?
        NoSessionAuthenticationProvider.getInstance() : authenticationProvider;
  }

  @Override
  protected void configureAuthentication(HttpURLConnection connection)
      throws AuthenticationException {
    String authenticationToken = authenticationProvider.getAuthorizationToken(this);
    if (authenticationToken == null) {
      throw new AuthenticationException(
          "Authentication is required for this service, but no authentication has been provided to "
              + "the service"
      );
    }
    addAuthorizationHeader(authenticationToken, connection);
  }

  private void addAuthorizationHeader(String authenticationToken, HttpURLConnection connection) {
    connection.setRequestProperty("Authorization", authenticationToken);
  }

}
