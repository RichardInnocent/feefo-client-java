package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, Collections.emptyList())
            .getPath()
    );
  }

  @Test
  public void getPath_SingleParameter_ReturnsBasePathPlusUrlEncodedParameter()
      throws UnsupportedEncodingException {
    String basePath = "basePath";

    QueryParameter parameter = mock(QueryParameter.class);
    when(parameter.toQueryStringForm()).thenReturn("key=value");

    Collection<QueryParameter> parameters = Collections.singleton(parameter);

    assertEquals(
        basePath + "?" + parameter.toQueryStringForm(),
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, parameters)
            .getPath()
    );
  }

  @Test
  public void getPath_MultipleParameters_ReturnsBasePathPlusUrlEncodedParameters()
      throws UnsupportedEncodingException {
    String basePath = "basePath";

    QueryParameter parameter1 = mock(QueryParameter.class);
    QueryParameter parameter2 = mock(QueryParameter.class);
    QueryParameter parameter3 = mock(QueryParameter.class);

    when(parameter1.toQueryStringForm()).thenReturn("key1=value1");
    when(parameter2.toQueryStringForm()).thenReturn("key2=value2");
    when(parameter3.toQueryStringForm()).thenReturn("key3=value3");

    Collection<QueryParameter> queryParameters = Arrays.asList(
        parameter1, parameter2, parameter3
    );

    String expectedUrl = String.format(
        "%s?%s&%s&%s",
        basePath,
        parameter1.toQueryStringForm(),
        parameter2.toQueryStringForm(),
        parameter3.toQueryStringForm()
    );

    assertEquals(
        expectedUrl,
        new TestFeefoApiRequest<>(new TypeReference<Object>() {}, basePath, queryParameters)
            .getPath()
    );
  }

  private static class TestFeefoApiRequest<T> extends AbstractFeefoApiRequest<T> {

    private final String basePath;
    private final Collection<QueryParameter> requestParameters;

    protected TestFeefoApiRequest(
        TypeReference<T> responseTypeReference,
        String basePath,
        Collection<QueryParameter> queryParameters) {
      super(responseTypeReference);
      this.basePath = basePath;
      this.requestParameters = queryParameters;
    }

    @Override
    protected String getBasePath() {
      return basePath;
    }

    @Override
    protected Collection<QueryParameter> getQueryParameters() {
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