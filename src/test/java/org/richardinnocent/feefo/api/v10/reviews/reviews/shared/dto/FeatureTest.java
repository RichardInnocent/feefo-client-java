package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class FeatureTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(Feature.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

}