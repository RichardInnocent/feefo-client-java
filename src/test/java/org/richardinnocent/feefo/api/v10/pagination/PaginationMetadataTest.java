package org.richardinnocent.feefo.api.v10.pagination;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class PaginationMetadataTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(PaginationMetadata.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

}