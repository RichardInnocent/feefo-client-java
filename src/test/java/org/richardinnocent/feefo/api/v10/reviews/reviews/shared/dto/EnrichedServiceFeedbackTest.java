package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class EnrichedServiceFeedbackTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(EnrichedServiceFeedback.class)
                  .suppress(Warning.NONFINAL_FIELDS, Warning.STRICT_INHERITANCE)
                  .verify();
  }

}