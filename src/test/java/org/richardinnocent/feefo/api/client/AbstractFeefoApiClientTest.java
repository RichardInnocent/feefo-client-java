package org.richardinnocent.feefo.api.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        new TestFeefoApiClient(baseUrl, null, null).getBaseUrl()
    );
  }

  @Test
  @SuppressWarnings("unchecked")
  public void execute_InvalidUrl_ExceptionThrown() {
    try {
      FeefoApiClient client =
          new TestFeefoApiClient("invalid", mock(ObjectMapper.class), connection -> {});
      client.execute(mock(FeefoApiRequest.class));
      fail("No exception thrown");
    } catch (FeefoApiRequestFailedException e) {
      assertTrue(e.getCause() instanceof MalformedURLException);
    }
  }

  private static class TestFeefoApiClient extends AbstractFeefoApiClient {
    private final ObjectMapper objectMapper;
    private final Consumer<HttpURLConnection> authenticationConfigurer;

    public TestFeefoApiClient(
        String baseUrl,
        ObjectMapper objectMapper,
        Consumer<HttpURLConnection> authenticationConfigurer) {
      super(baseUrl);
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