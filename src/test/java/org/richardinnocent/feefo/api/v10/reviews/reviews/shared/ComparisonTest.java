package org.richardinnocent.feefo.api.v10.reviews.reviews.shared;

import static org.junit.jupiter.api.Assertions.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.requests.EqualityOperator;

class ComparisonTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(Comparison.class).suppress(Warning.STRICT_INHERITANCE).verify();
  }

  @Test
  public void constructor_ComparatorIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new Comparison<>(null, "Reference"));
  }

  @Test
  public void constructor_ReferenceIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new Comparison<>(EqualityOperator.EQUALS, null));
  }

  @Test
  public void constructor_ValidCall_FieldsAreSetAsExpected() {
    EqualityOperator equalityOperator = EqualityOperator.LESS_THAN;
    int reference = 7;
    Comparison<Integer> comparison = new Comparison<>(equalityOperator, reference);
    assertEquals(equalityOperator, comparison.getEqualityOperator());
    assertEquals(reference, comparison.getReference());
  }

}