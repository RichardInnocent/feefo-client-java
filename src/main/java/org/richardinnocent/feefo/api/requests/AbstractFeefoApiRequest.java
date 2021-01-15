package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;

public abstract class AbstractFeefoApiRequest<R> implements FeefoApiRequest<R> {

  private final TypeReference<R> responseTypeReference;

  protected AbstractFeefoApiRequest(TypeReference<R> responseTypeReference) {
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
    getParameterString().ifPresent(pathBuilder::append);
    return pathBuilder.toString();
  }

  private Optional<String> getParameterString() {
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

  protected abstract String getBasePath();

  protected abstract Map<String, String> getRequestParameters();
}
