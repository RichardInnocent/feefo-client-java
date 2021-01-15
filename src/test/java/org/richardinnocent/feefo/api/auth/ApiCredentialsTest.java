package org.richardinnocent.feefo.api.auth;

import static org.junit.jupiter.api.Assertions.*;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

public class ApiCredentialsTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(ApiCredentials.class).suppress(Warning.STRICT_INHERITANCE).verify();
  }

  @Test
  public void builderForMerchantIdentifier_IdentifierIsNull_ExceptionThrown() {
    try {
      ApiCredentials.builder().forMerchantIdentifier(null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Merchant identifier should be specified but is null", e.getMessage());
    }
  }

  @Test
  public void builderForMerchantIdentifier_IdentifierIsEmpty_ExceptionThrown() {
    try {
      ApiCredentials.builder().forMerchantIdentifier("");
      fail("No exception thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("Merchant identifier should be specified but is empty", e.getMessage());
    }
  }

  @Test
  public void builderForApiKey_KeyIsNull_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey(null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("An API key should be specified but is null", e.getMessage());
    }
  }

  @Test
  public void builderForApiKey_KeyIsEmpty_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey("");
      fail("No exception thrown");
    } catch (IllegalArgumentException e) {
      assertEquals("An API key should be specified but is empty", e.getMessage());
    }
  }

  @Test
  public void builderWithUsername_UsernameIsNull_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey("api-key")
          .withUsername(null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals(
          "The credentials for a merchant admin Feefo account must be used to authenticate the "
              + "requests, but the provided username is null",
          e.getMessage()
      );
    }
  }

  @Test
  public void builderWithUsername_UsernameIsEmpty_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey("api-key")
          .withUsername("");
      fail("No exception thrown");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The credentials for a merchant admin Feefo account must be used to authenticate the "
              + "requests, but the provided username is empty",
          e.getMessage()
      );
    }
  }

  @Test
  public void builderWithPassword_PasswordIsNull_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey("api-key")
          .withUsername("user@test.com")
          .withPassword(null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals(
          "The credentials for a merchant admin Feefo account must be used to authenticate the "
              + "requests, but the provided password is null",
          e.getMessage()
      );
    }
  }

  @Test
  public void builderWithPassword_PasswordIsEmpty_ExceptionThrown() {
    try {
      ApiCredentials
          .builder()
          .forMerchantIdentifier("merchant-identifier")
          .withApiKey("api-key")
          .withUsername("user@test.com")
          .withPassword("");
      fail("No exception thrown");
    } catch (IllegalArgumentException e) {
      assertEquals(
          "The credentials for a merchant admin Feefo account must be used to authenticate the "
              + "requests, but the provided password is empty",
          e.getMessage()
      );
    }
  }

  @Test
  public void builderBuild_ValidValues_CreatesCredentials() {
    String merchantIdentifier = "merchant-identifier";
    String apiKey = "api-key";
    String username = "user@test.com";
    String password = "test-password";

    ApiCredentials credentials =
        ApiCredentials.builder()
                      .forMerchantIdentifier(merchantIdentifier)
                      .withApiKey(apiKey)
                      .withUsername(username)
                      .withPassword(password)
                      .build();

    assertEquals(merchantIdentifier, credentials.getMerchantIdentifier());
    assertEquals(apiKey, credentials.getApiKey());
    assertEquals(username, credentials.getUsername());
    assertEquals(password, credentials.getPassword());
  }

}