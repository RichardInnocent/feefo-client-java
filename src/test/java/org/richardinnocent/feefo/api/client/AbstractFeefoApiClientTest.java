package org.richardinnocent.feefo.api.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;
import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

class AbstractFeefoApiClientTest {

  @Test
  public void getBaseUrl_Always_Correct() {
    String baseUrl = "https://api.feefo.com/api";
    assertEquals(
        baseUrl,
        new TestFeefoApiClient(baseUrl, null, null, mock(HttpConnectionFactory.class)).getBaseUrl()
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void execute_InvalidUrl_ExceptionThrown() {
    IOException cause = mock(MalformedURLException.class);
    HttpConnectionFactory httpConnectionFactory = url -> {throw cause;};
    try {
      FeefoApiClient client =
          new TestFeefoApiClient(
              "invalid", mock(ObjectMapper.class), connection -> {}, httpConnectionFactory);
      client.execute(mock(FeefoApiRequest.class));
      fail("No exception thrown");
    } catch (FeefoApiRequestFailedException e) {
      assertTrue(e.getCause() instanceof MalformedURLException);
    }
  }

  @Test
  @SuppressWarnings("unchecked")
  public void execute_ValidRequestWithNoAuthentication_RequestIsSent() throws Exception {
    HttpURLConnection httpConnection = mock(HttpURLConnection.class);
    HttpConnectionFactory httpConnectionFactory = url -> httpConnection;
    ObjectMapper objectMapper = mock(ObjectMapper.class);

    FeefoApiClient client =
        new TestFeefoApiClient(
            "baseUrl", objectMapper, mock(Consumer.class), httpConnectionFactory);

    FeefoApiRequest<Object> request = mock(FeefoApiRequest.class);
    when(request.requiresAuthentication()).thenReturn(false);
    when(request.getResponseTypeReference()).thenReturn(new TypeReference<Object>(){});

    InputStream responseInputStream = mock(InputStream.class);
    when(httpConnection.getInputStream()).thenReturn(responseInputStream);

    Object response = mock(Object.class);
    when(objectMapper.readValue(eq(responseInputStream), any(TypeReference.class)))
        .thenReturn(response);

    assertEquals(response, client.execute(request));
    verify(request, times(1)).configureConnection(httpConnection, objectMapper);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void execute_ValidRequestWithAuthentication_RequestIsSentAndAuthenticated()
      throws Exception {
    HttpURLConnection httpConnection = mock(HttpURLConnection.class);
    HttpConnectionFactory httpConnectionFactory = url -> httpConnection;
    Consumer<HttpURLConnection> authenticationConfigurer =
        connection -> connection.setRequestProperty("authorised", "true");
    ObjectMapper objectMapper = mock(ObjectMapper.class);

    FeefoApiClient client =
        new TestFeefoApiClient(
            "baseUrl", objectMapper, authenticationConfigurer, httpConnectionFactory);

    FeefoApiRequest<Object> request = mock(FeefoApiRequest.class);
    when(request.requiresAuthentication()).thenReturn(true);
    when(request.getResponseTypeReference()).thenReturn(new TypeReference<Object>(){});

    InputStream responseInputStream = mock(InputStream.class);
    when(httpConnection.getInputStream()).thenReturn(responseInputStream);

    Object response = mock(Object.class);
    when(objectMapper.readValue(eq(responseInputStream), any(TypeReference.class)))
        .thenReturn(response);

    assertEquals(response, client.execute(request));
    verify(request, times(1)).configureConnection(httpConnection, objectMapper);
    verify(httpConnection, times(1)).setRequestProperty("authorised", "true");
  }

  private static class TestFeefoApiClient extends AbstractFeefoApiClient {
    private final ObjectMapper objectMapper;
    private final Consumer<HttpURLConnection> authenticationConfigurer;

    public TestFeefoApiClient(
        String baseUrl,
        ObjectMapper objectMapper,
        Consumer<HttpURLConnection> authenticationConfigurer,
        HttpConnectionFactory httpConnectionFactory) {
      super(baseUrl, httpConnectionFactory);
      this.objectMapper = objectMapper;
      this.authenticationConfigurer = authenticationConfigurer;
    }

    @Override
    protected ObjectMapper getObjectMapper() {
      return objectMapper;
    }

    @Override
    protected void configureAuthentication(HttpURLConnection connection) {
      if (authenticationConfigurer != null) {
        authenticationConfigurer.accept(connection);
      }
    }
  }

}