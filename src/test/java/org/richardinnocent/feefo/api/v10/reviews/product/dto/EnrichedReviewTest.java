package org.richardinnocent.feefo.api.v10.reviews.product.dto;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class EnrichedReviewTest {

  @Test
  public void equalAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(EnrichedReview.class)
                  .suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE)
                  .verify();
  }

}