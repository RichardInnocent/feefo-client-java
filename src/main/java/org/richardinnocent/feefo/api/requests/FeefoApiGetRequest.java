package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.richardinnocent.feefo.api.FeefoApiRequestFailedException;

public abstract class FeefoApiGetRequest<R> extends AbstractFeefoApiRequest<R> {

  private final Map<String, String> requestParameters;

  public FeefoApiGetRequest(TypeReference<R> responseTypeReference, Map<String, String> requestParameters) {
    super(responseTypeReference);
    this.requestParameters = requestParameters == null ? Collections.emptyMap() : requestParameters;
  }

  @Override
  public String getPath() {
    StringBuilder pathBuilder = new StringBuilder(getBasePath());
    getParameterString().ifPresent(pathBuilder::append);
    return pathBuilder.toString();
  }

  private Optional<String> getParameterString() {
    if (requestParameters.isEmpty()) {
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

  @Override
  public void configureConnection(HttpURLConnection connection, ObjectMapper objectMapper)
      throws Exception {
    connection.setRequestMethod("GET");
  }

}
