package org.richardinnocent.feefo.api.auth;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class AuthenticationTokenTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(AuthenticationToken.class)
                  .suppress(Warning.STRICT_INHERITANCE)
                  .verify();
  }

  @Test
  public void of_TokenIsNull_ExceptionThrown() {
    try {
      AuthenticationToken.of(null, LocalDateTime.now());
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Token must be set", e.getMessage());
    }
  }

  @Test
  public void of_ExpirationTimeIsNull_ExceptionThrown() {
    try {
      AuthenticationToken.of("test-token", null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Expiration time must be set", e.getMessage());
    }
  }

  @Test
  public void of_ValidInput_ValuesAreSet() {
    String token = "test-token";
    LocalDateTime expirationTime = LocalDateTime.now();
    AuthenticationToken authenticationToken = AuthenticationToken.of(token, expirationTime);
    assertEquals(token, authenticationToken.getToken());
    assertEquals(expirationTime, authenticationToken.getExpirationTime());
  }

}