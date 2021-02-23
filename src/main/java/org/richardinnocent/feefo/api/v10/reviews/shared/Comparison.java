package org.richardinnocent.feefo.api.v10.reviews.shared;

import java.util.Objects;
import org.richardinnocent.feefo.api.requests.EqualityOperator;

/**
 * Portrays a comparison between the actual value and a reference value.
 * @param <T>
 */
public class Comparison<T> {

  private final EqualityOperator equalityOperator;
  private final T reference;

  /**
   * Creates a new comparison.
   * @param equalityOperator The equality operator to apply.
   * @param reference The reference value.
   * @throws NullPointerException Thrown if {@code equalityOperator == null || reference == null}.
   */
  public Comparison(EqualityOperator equalityOperator, T reference) throws NullPointerException {
    this.equalityOperator = Objects.requireNonNull(equalityOperator, "Comparator is null");
    this.reference = Objects.requireNonNull(reference, "Comparison reference is null");
  }

  /**
   * Gets the equality operator.
   * @return The equality operator.
   */
  public EqualityOperator getEqualityOperator() {
    return equalityOperator;
  }

  /**
   * Gets the reference value.
   * @return The reference value.
   */
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
