package org.richardinnocent.feefo.api.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Objects;

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
}
