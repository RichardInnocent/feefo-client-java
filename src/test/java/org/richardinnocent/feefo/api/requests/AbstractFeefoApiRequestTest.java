package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AbstractFeefoApiRequestTest {

  @Test
  public void constructor_ResponseTypeReferenceSpecified_TypeReferenceSet() {
    TypeReference<?> typeReference = mock(TypeReference.class);
    assertEquals(
        typeReference,
        new TestFeefoApiRequest<>(typeReference, null, null).getResponseTypeReference()
    );
  }

  @Test
  public void constructor_ResponseTypeReferenceIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new TestFeefoApiRequest<>(null, null, null)
    );
  }

  @Test
  public void getPath_ParametersAreNull_ReturnsBasePath() {
    String basePath = "basePath";
    assertEquals(
        basePath,
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, null).getPath()
    );
  }

  @Test
  public void getPath_ParametersAreEmpty_ReturnsBasePath() {
    String basePath = "basePath";
    assertEquals(
        basePath,
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, Collections.emptyMap())
            .getPath()
    );
  }

  @Test
  public void getPath_SingleParameter_ReturnsBasePathPlusUrlEncodedParameter() {
    String basePath = "basePath";
    Map<String, String> requestParameters = Collections.singletonMap("test key", "test value");
    assertEquals(
        basePath + "?test+key=test+value",
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, requestParameters)
            .getPath()
    );
  }

  @Test
  public void getPath_MultipleParameters_ReturnsBasePathPlusUrlEncodedParameters() {
    String basePath = "basePath";
    Map<String, String> requestParameters = new HashMap<>(3);
    requestParameters.put("key1", "value1");
    requestParameters.put("key2", "value 2");
    requestParameters.put("key3", "value  3");
    assertEquals(
        basePath + "?key1=value1&key2=value+2&key3=value++3",
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, requestParameters)
            .getPath()
    );
  }

  private static class TestFeefoApiRequest<T> extends AbstractFeefoApiRequest<T> {

    private final String basePath;
    private final Map<String, String> requestParameters;

    protected TestFeefoApiRequest(
        TypeReference<T> responseTypeReference,
        String basePath,
        Map<String, String> requestParameters) {
      super(responseTypeReference);
      this.basePath = basePath;
      this.requestParameters = requestParameters;
    }

    @Override
    protected String getBasePath() {
      return basePath;
    }

    @Override
    protected Map<String, String> getRequestParameters() {
      return requestParameters;
    }

    @Override
    public void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper) {}

    @Override
    public boolean requiresAuthentication() {
      return false;
    }
  }

}