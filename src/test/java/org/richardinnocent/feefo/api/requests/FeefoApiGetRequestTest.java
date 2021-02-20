package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.type.TypeReference;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FeefoApiGetRequestTest {

  @Test
  public void constructor_TypeReferenceSpecified_TypeReferenceSetCorrectly() {
    TypeReference<?> typeReference = mock(TypeReference.class);
    assertEquals(typeReference, new TestGetRequest<>(typeReference).getResponseTypeReference());
  }

  @Test
  public void constructor_TypeReferenceIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new TestGetRequest<>(null));
  }

  @Test
  public void configureConnections_Always_SetsRequestMethodToGet() throws Exception {
    FeefoApiGetRequest<Object> request = new TestGetRequest<>(new TypeReference<Object>(){});
    HttpURLConnection connection = mock(HttpURLConnection.class);
    request.configureConnection(connection, null);
    verify(connection, times(1)).setRequestMethod("GET");
  }

  private static class TestGetRequest<R> extends FeefoApiGetRequest<R> {

    private TestGetRequest(TypeReference<R> responseTypeReference) throws NullPointerException {
      super(responseTypeReference);
    }

    @Override
    protected String getBasePath() {
      return null;
    }

    @Override
    protected Collection<QueryParameter> getQueryParameters() {
      return null;
    }

    @Override
    public boolean requiresAuthentication() {
      return false;
    }
  }

}