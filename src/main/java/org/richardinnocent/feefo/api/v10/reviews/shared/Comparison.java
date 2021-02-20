package org.richardinnocent.feefo.api.v10.reviews.shared;

import java.util.Objects;
import org.richardinnocent.feefo.api.requests.EqualityOperator;

public class Comparison<T> {

  private final EqualityOperator equalityOperator;
  private final T reference;

  public Comparison(EqualityOperator equalityOperator, T reference) throws NullPointerException {
    this.equalityOperator = Objects.requireNonNull(equalityOperator, "Comparator is null");
    this.reference = Objects.requireNonNull(reference, "Comparison reference is null");
  }

  public EqualityOperator getComparator() {
    return equalityOperator;
  }

  public T getReference() {
    return reference;
  }

  @Override
  public String toString() {
    return equalityOperator.getSymbol() + reference.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comparison<?> that = (Comparison<?>) o;
    return equalityOperator == that.equalityOperator && Objects.equals(reference, that.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equalityOperator, reference);
  }
}
