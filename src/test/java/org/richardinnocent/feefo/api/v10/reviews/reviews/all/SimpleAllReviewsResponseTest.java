package org.richardinnocent.feefo.api.v10.reviews.reviews.all;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class SimpleAllReviewsResponseTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(SimpleAllReviewsResponse.class)
                  .suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE)
                  .verify();
  }

}