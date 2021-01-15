package org.richardinnocent.feefo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.naming.AuthenticationException;
import org.richardinnocent.feefo.api.client.FeefoApiClient;
import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

public abstract class AbstractFeefoApiClient implements FeefoApiClient {

  @Override
  public String getBaseUrl() {
    return "https://api.feefo.com/api";
  }

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

  protected abstract void configureAuthentication(HttpURLConnection connection)
      throws AuthenticationException;

}
