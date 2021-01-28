package org.richardinnocent.feefo.api.v10.reviews.shared;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class ProductFeedbackTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(ProductFeedback.class)
                  .suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE)
                  .verify();
  }

}