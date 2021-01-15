package org.richardinnocent.feefo.api.client;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.Test;

class AbstractFeefoApiClientTest {

  @Test
  public void getBaseUrl_Always_Correct() {
    String baseUrl = "https://api.feefo.com/api";
    FeefoApiClient client = new AbstractFeefoApiClient(baseUrl) {
      @Override
      protected ObjectMapper getObjectMapper() {
        return null;
      }

      @Override
      protected void configureAuthentication(HttpURLConnection connection) {}
    };
    assertEquals(baseUrl, client.getBaseUrl());
  }

}