package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;
import org.richardinnocent.feefo.api.UnauthorisedException;
import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

/**
 * Abstract implementation of the {@link FeefoApiClient}.
 */
public abstract class AbstractFeefoApiClient implements FeefoApiClient {

  private final String baseUrl;
  private final HttpConnectionFactory httpConnectionFactory;

  protected AbstractFeefoApiClient(String baseUrl, HttpConnectionFactory httpConnectionFactory)
      throws NullPointerException {
    this.baseUrl = Objects.requireNonNull(baseUrl, "Base URL is null");
    this.httpConnectionFactory =
        Objects.requireNonNull(httpConnectionFactory, "HTTP connection factory is null");
  }

  @Override
  public String getBaseUrl() {
    return baseUrl;
  }

  /**
   * Gets the object mapper that should be used to build POST requests bodies, and convert responses
   * into the expected return types.
   * @return The object mapper used.
   */
  protected abstract ObjectMapper getObjectMapper();

  @Override
  public <R> R execute(FeefoApiRequest<R> request) throws FeefoApiRequestFailedException {
    String url = getBaseUrl() + request.getPath();
    try {
      HttpURLConnection connection = httpConnectionFactory.create(url);
      if (request.requiresAuthentication()) {
        configureAuthentication(connection);
      }

      request.configureConnection(connection, getObjectMapper());

      InputStream response = connection.getInputStream();
      return getObjectMapper().readValue(response, request.getResponseTypeReference());
    } catch (Exception e) {
      throw new FeefoApiRequestFailedException(
          "Request to Feefo API failed. Target URL: " + url, e);
    }
  }

  /**
   * Configures the authentication for this request. This should include adding the authorization
   * header.
   * @param connection The connection to configure.
   * @throws UnauthorisedException Thrown if there is a problem configuring the authentication.
   */
  protected abstract void configureAuthentication(HttpURLConnection connection)
      throws UnauthorisedException;

}
