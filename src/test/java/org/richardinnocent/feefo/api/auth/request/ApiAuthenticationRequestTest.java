package org.richardinnocent.feefo.api.auth.request;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.richardinnocent.feefo.api.auth.ApiCredentials;

public class ApiAuthenticationRequestTest {

  @Test
  public void builderBuild_ValidObject_ReturnsRequest() throws Exception {
    ApiCredentials credentials =
        ApiCredentials
            .builder()
            .forMerchantIdentifier("merchant-identifier")
            .withApiKey("api-key")
            .withUsername("user@test.com")
            .withPassword("test-password")
            .build();

    ApiAuthenticationRequest request = new ApiAuthenticationRequest(credentials);

    HttpURLConnection connection = mock(HttpURLConnection.class);
    OutputStream connectionWriter = mock(OutputStream.class);
    when(connection.getOutputStream()).thenReturn(connectionWriter);
    ArgumentCaptor<byte[]> bodyCaptor = ArgumentCaptor.forClass(byte[].class);

    ObjectMapper objectMapper = new ObjectMapper();
    request.configureConnection(connection, objectMapper);

    verify(connection, times(1)).setRequestMethod("POST");
    verify(connection, times(1)).setRequestProperty("Accept", "application/json");
    verify(connection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
    verify(connection, times(1)).setDoOutput(true);
    verify(connectionWriter, times(1)).write(bodyCaptor.capture());

    Map<String, ApiAuthenticationRequestDto> sentRequest =
        objectMapper.readValue(
            bodyCaptor.getValue(),
            new TypeReference<Map<String, ApiAuthenticationRequestDto>>() {}
        );

    ApiAuthenticationRequestDto sentCredentials = sentRequest.get("authenticationDTO");
    assertEquals(credentials.getMerchantIdentifier(), sentCredentials.getMerchantIdentifier());
    assertEquals(credentials.getApiKey(), sentCredentials.getApiKey());
    assertEquals(credentials.getUsername(), sentCredentials.getUsername());
    assertEquals(credentials.getPassword(), sentCredentials.getPassword());
  }

}