package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.richardinnocent.feefo.api.CouldNotCreateRequestException;

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

  private Optional<String> getQueryString() throws CouldNotCreateRequestException {
    Collection<QueryParameter> queryParameters = getQueryParameters();
    if (queryParameters == null || getQueryParameters().isEmpty()) {
      return Optional.empty();
    }

    String queryString =
        queryParameters.stream().map(this::toRequestParameter).collect(Collectors.joining("&"));

    return Optional.of('?' + queryString);
  }

  private String toRequestParameter(QueryParameter queryParameter)
      throws CouldNotCreateRequestException {
    try {
      return queryParameter.toQueryStringForm();
    } catch (UnsupportedEncodingException e) {
      throw new CouldNotCreateRequestException(
          "Could not convert parameter " + queryParameter + " to URL-encoded value", e
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
   * applicable, an empty collection or {@code null} can be returned.
   */
  protected abstract Collection<QueryParameter> getQueryParameters();
}
