package org.richardinnocent.feefo.api.v10.reviews.reviews.service;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class EnrichedServiceReviewsResponseTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(EnrichedServiceReviewsResponse.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

}