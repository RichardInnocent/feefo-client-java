package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.util.Objects;
import javax.naming.AuthenticationException;
import org.richardinnocent.feefo.api.UnauthorisedException;
import org.richardinnocent.feefo.api.auth.AuthenticationProvider;
import org.richardinnocent.feefo.api.auth.NoSessionAuthenticationProvider;
import org.richardinnocent.feefo.api.mapping.FeefoApiObjectMapper;

/**
 * Implementation of a {@link FeefoApiClient}.
 */
public class FeefoApiClientImpl extends AbstractFeefoApiClient {

  private static final String DEFAULT_BASE_URL = "https://api.feefo.com/api";

  private final AuthenticationProvider authenticationProvider;
  private final ObjectMapper objectMapper;

  @Override
  protected ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  /**
   * Creates a client that will target all requests at the default base URL
   * ({@code https://api.feefo.com/api...}). This client will be unable to process any requests
   * that require authentication, as no {@link AuthenticationProvider} has been specified.
   */
  public FeefoApiClientImpl() {
    this(DEFAULT_BASE_URL, null, new FeefoApiObjectMapper());
  }

  /**
   * Creates a client that will target all requests at the default base URL
   * ({@code https://api.feefo.com/api...}).
   * @param authenticationProvider Used to generate the credentials. This will only be utilised
   * when the request being sent requires authorisation.
   */
  public FeefoApiClientImpl(AuthenticationProvider authenticationProvider) {
    this(DEFAULT_BASE_URL, authenticationProvider, new FeefoApiObjectMapper());
  }

  /**
   * Creates a client to interact with Feefo.
   * @param baseUrl The base URL, e.g. {@code https://api.feefo.com/api}. This should not end in a
   * trailing forward slash.
   * @param authenticationProvider Used to generate the credentials. This will only be utilised
   * when the request being sent requires authorisation.
   * @param objectMapper Used to map the requests/responses from/to their appropriate object type.
   */
  public FeefoApiClientImpl(
      String baseUrl, AuthenticationProvider authenticationProvider, ObjectMapper objectMapper) {
    super(baseUrl);
    this.objectMapper = Objects.requireNonNull(objectMapper, "Object mapper is null");
    this.authenticationProvider = authenticationProvider == null ?
        NoSessionAuthenticationProvider.getInstance() : authenticationProvider;
  }

  @Override
  protected void configureAuthentication(HttpURLConnection connection)
      throws UnauthorisedException {
    String authenticationToken = authenticationProvider.getAuthorizationToken(this);
    if (authenticationToken == null) {
      throw new UnauthorisedException(
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
