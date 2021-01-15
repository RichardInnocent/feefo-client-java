package org.richardinnocent.feefo.api.auth.request;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class ApiAuthenticationResponseTest {

  @Test
  public void equalsAndHashcode_Always_Valid() {
    EqualsVerifier.forClass(ApiAuthenticationResponse.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

}