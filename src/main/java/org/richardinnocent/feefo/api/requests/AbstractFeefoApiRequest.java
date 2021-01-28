package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;

/**
 * Abstract implementation of a request to be sent to the Feefo API.
 * @param <R> The response type.
 */
public abstract class AbstractFeefoApiRequest<R> implements FeefoApiRequest<R> {

  private final TypeReference<R> responseTypeReference;

  /**
   * Creates a new request.
   * @param responseTypeReference The type reference of the response.
   * @throws NullPointerException Thrown if {@code responseTypeReference == null}.
   */
  protected AbstractFeefoApiRequest(TypeReference<R> responseTypeReference)
      throws NullPointerException {
    this.responseTypeReference =
        Objects.requireNonNull(responseTypeReference, "Response type reference is null");
  }

  @Override
  public TypeReference<R> getResponseTypeReference() {
    return responseTypeReference;
  }

  @Override
  public String getPath() {
    StringBuilder pathBuilder = new StringBuilder(getBasePath());
    getQueryString().ifPresent(pathBuilder::append);
    return pathBuilder.toString();
  }

  private Optional<String> getQueryString() {
    Map<String, String> requestParameters = getRequestParameters();
    if (requestParameters == null || getRequestParameters().isEmpty()) {
      return Optional.empty();
    }
    String parameterString =
        requestParameters.entrySet()
                         .stream()
                         .map(this::toRequestParameter).collect(Collectors.joining("&"));
    return Optional.of('?' + parameterString);
  }

  private String toRequestParameter(Map.Entry<String, String> parameter) {
    try {
      String key = URLEncoder.encode(parameter.getKey(), StandardCharsets.UTF_8.toString());
      String value = URLEncoder.encode(parameter.getValue(), StandardCharsets.UTF_8.toString());
      return key + '=' + value;
    } catch (UnsupportedEncodingException e) {
      throw new FeefoApiRequestFailedException(
          "Could not convert parameter [" + parameter.getKey() + "="
              + parameter.getValue() + "] to URL-encoded value",
          e
      );
    }
  }

  /**
   * Gets the base path of the request. This should exclude the hostname and the query string, and
   * not end in a forward slash.
   * @return The base path of the request. This should never be {@code null}.
   */
  protected abstract String getBasePath();

  /**
   * Gets the request parameters that should be added as a query string.
   * @return The request parameters that should be added as a query string. If this is not
   * applicable, {@link Collections#emptyMap()} or {@code null} can be returned.
   */
  protected abstract Map<String, String> getRequestParameters();
}
