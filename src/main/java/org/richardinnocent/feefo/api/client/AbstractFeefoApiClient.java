package org.richardinnocent.feefo.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.naming.AuthenticationException;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;
import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

/**
 * Abstract implementation of the {@link FeefoApiClient}.
 */
public abstract class AbstractFeefoApiClient implements FeefoApiClient {

  @Override
  public String getBaseUrl() {
    return "https://api.feefo.com/api";
  }

  /**
   * Gets the object mapper that should be used to build POST requests bodies, and convert responses
   * into the expected return types.
   * @return The object mapper used.
   */
  protected abstract ObjectMapper getObjectMapper();

  @Override
  public <R> R execute(FeefoApiRequest<R> request) {
    String urlAsText = getBaseUrl() + request.getPath();
    try {
      URL url = new URL(urlAsText);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      if (request.requiresAuthentication()) {
        configureAuthentication(connection);
      }

      request.configureConnection(connection, getObjectMapper());

      InputStream response = connection.getInputStream();
      return getObjectMapper().readValue(response, request.getResponseTypeReference());
    } catch (Exception e) {
      throw new FeefoApiRequestFailedException(
          "Request to Feefo API failed. Target URL: " + urlAsText, e);
    }
  }

  /**
   * Configures the authentication for this request. This should include adding the authorization
   * header.
   * @param connection The connection to configure.
   * @throws AuthenticationException Thrown if there is a problem configuring the authentication.
   */
  protected abstract void configureAuthentication(HttpURLConnection connection)
      throws AuthenticationException;

}