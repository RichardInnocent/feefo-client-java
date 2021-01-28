package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
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

      connection.connect();
      int responseCode = connection.getResponseCode();

      if (responseCode < 400) {
        InputStream response = connection.getInputStream();
        return getObjectMapper().readValue(response, request.getResponseTypeReference());
      } else {
        throw createExceptionForResponse(connection);
      }

    } catch (Exception e) {
      throw new FeefoApiRequestFailedException(
          "Request to Feefo API failed. Target URL: " + url, e);
    }
  }

  private FeefoApiRequestFailedException createExceptionForResponse(HttpURLConnection connection)
      throws IOException {
    String exceptionMessage = "Request failed with status " + connection.getResponseMessage();

    InputStream responseStream = connection.getErrorStream();
    if (responseStream != null) {
      Collection<String> lines = new ArrayList<>();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream))) {
        String line;
        while ((line = reader.readLine()) != null) {
          lines.add(line);
        }
      }
      exceptionMessage += ". Cause: " + String.join(System.lineSeparator(), lines);
    }

    return new FeefoApiRequestFailedException(exceptionMessage);
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
