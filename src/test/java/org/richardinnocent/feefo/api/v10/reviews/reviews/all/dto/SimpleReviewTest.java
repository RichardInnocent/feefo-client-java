package org.richardinnocent.feefo.api.v10.reviews.reviews.all.dto;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class SimpleReviewTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(SimpleReview.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

}