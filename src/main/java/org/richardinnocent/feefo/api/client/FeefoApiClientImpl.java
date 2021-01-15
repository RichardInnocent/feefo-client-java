package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.util.Objects;
import javax.naming.AuthenticationException;
import org.richardinnocent.feefo.api.auth.AuthenticationProvider;
import org.richardinnocent.feefo.api.auth.NoSessionAuthenticationProvider;
import org.richardinnocent.feefo.api.mapping.FeefoApiObjectMapper;

public class FeefoApiClientImpl extends AbstractFeefoApiClient {

  private final AuthenticationProvider authenticationProvider;
  private final ObjectMapper objectMapper;

  @Override
  protected ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  public FeefoApiClientImpl() {
    this(null, null);
  }

  public FeefoApiClientImpl(AuthenticationProvider authenticationProvider) {
    this(authenticationProvider, new FeefoApiObjectMapper());
  }

  public FeefoApiClientImpl(
      AuthenticationProvider authenticationProvider, ObjectMapper objectMapper) {
    this.objectMapper = Objects.requireNonNull(objectMapper, "Object mapper is null");
    this.authenticationProvider = authenticationProvider == null ?
        NoSessionAuthenticationProvider.getInstance() : authenticationProvider;
  }

  @Override
  protected void configureAuthentication(HttpURLConnection connection)
      throws AuthenticationException {
    String authenticationToken = authenticationProvider.getAuthenticationToken(this);
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
