package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FeefoApiPostRequestTest {

  @Test
  public void constructor_ResponseTypeReferenceSpecified_TypeReferenceSetCorrectly() {
    TypeReference<?> typeReference = mock(TypeReference.class);
    assertEquals(
        typeReference, new TestPostRequest<>(null, typeReference).getResponseTypeReference()
    );
  }

  @Test
  public void constructor_ResponseTypeReferenceIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new TestPostRequest<>(null, null));
  }

  @Test
  public void configureConnection_Always_PreparesConnectionThoroughly() throws Exception {
    HttpURLConnection connection = mock(HttpURLConnection.class);
    OutputStream outputStream = mock(OutputStream.class);
    when(connection.getOutputStream()).thenReturn(outputStream);

    ObjectMapper objectMapper = mock(ObjectMapper.class);
    String body = "body";
    when(objectMapper.writeValueAsString(body)).thenReturn(body);

    FeefoApiRequest<String> request = new TestPostRequest<>(body, new TypeReference<String>(){});
    request.configureConnection(connection, objectMapper);

    verify(connection, times(1)).setRequestMethod("POST");
    verify(connection, times(1)).setRequestProperty("Accept", "application/json");
    verify(connection, times(1)).setRequestProperty("Content-Type", "application/json; utf-8");
    verify(connection, times(1)).setDoOutput(true);
    verify(outputStream, times(1)).write(eq(body.getBytes(StandardCharsets.UTF_8)));
  }

  private static class TestPostRequest<B, R> extends FeefoApiPostRequest<B, R> {

    private TestPostRequest(B requestBody, TypeReference<R> responseTypeReference) {
      super(requestBody, responseTypeReference);
    }

    @Override
    protected String getBasePath() {
      return null;
    }

    @Override
    protected Map<String, String> getRequestParameters() {
      return null;
    }

    @Override
    public boolean requiresAuthentication() {
      return false;
    }
  }

}