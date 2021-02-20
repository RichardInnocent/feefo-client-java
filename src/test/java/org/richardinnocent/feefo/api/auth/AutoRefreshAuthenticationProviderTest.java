package org.richardinnocent.feefo.api.auth;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationRequest;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationResponse;
import org.richardinnocent.feefo.api.client.FeefoApiClient;

class AutoRefreshAuthenticationProviderTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(AutoRefreshAuthenticationProvider.class)
                  .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                  .verify();
  }

  @Test
  public void constructor_CredentialsAreNull_ThrowsException() {
    try {
      new AutoRefreshAuthenticationProvider(null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Credentials must be specified", e.getMessage());
    }
  }

  @Test
  public void getAuthorizationToken_TokenNeverSet_ExecutesAuthenticationRequest() {
    ApiCredentials credentials =
        ApiCredentials.builder()
                      .forMerchantIdentifier("test-merchant")
                      .withApiKey("test-api-key")
                      .withUsername("user@test.com")
                      .withPassword("test-password")
                      .build();

    ApiAuthenticationResponse response = new ApiAuthenticationResponse();
    response.setApiToken("test-token");
    response.setExpiresTime(ZonedDateTime.of(10_000, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")));

    FeefoApiClient client = mock(FeefoApiClient.class);
    when(client.execute(any(ApiAuthenticationRequest.class))).thenReturn(response);

    AutoRefreshAuthenticationProvider authenticationProvider =
        new AutoRefreshAuthenticationProvider(credentials);

    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
  }

  @Test
  public void getAuthorizationToken_TokenSetAndNotExpired_ReturnsSameToken() {
    ApiCredentials credentials =
        ApiCredentials.builder()
                      .forMerchantIdentifier("test-merchant")
                      .withApiKey("test-api-key")
                      .withUsername("user@test.com")
                      .withPassword("test-password")
                      .build();

    ApiAuthenticationResponse response = new ApiAuthenticationResponse();
    response.setApiToken("test-token");
    response.setExpiresTime(ZonedDateTime.of(10_000, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")));

    FeefoApiClient client = mock(FeefoApiClient.class);
    when(client.execute(any(ApiAuthenticationRequest.class))).thenReturn(response);

    AutoRefreshAuthenticationProvider authenticationProvider =
        new AutoRefreshAuthenticationProvider(credentials);

    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    assertEquals(response.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    verify(client, times(1)).execute(any(ApiAuthenticationRequest.class));
  }

  @Test
  public void getAuthorizationToken_TokenSetButExpired_GetsAnotherToken() {
    ApiCredentials credentials =
        ApiCredentials.builder()
                      .forMerchantIdentifier("test-merchant")
                      .withApiKey("test-api-key")
                      .withUsername("user@test.com")
                      .withPassword("test-password")
                      .build();

    ApiAuthenticationResponse expiredResponse = new ApiAuthenticationResponse();
    expiredResponse.setApiToken("test-token");
    expiredResponse.setExpiresTime(ZonedDateTime.of(0, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")));

    FeefoApiClient client = mock(FeefoApiClient.class);
    when(client.execute(any(ApiAuthenticationRequest.class))).thenReturn(expiredResponse);

    AutoRefreshAuthenticationProvider authenticationProvider =
        new AutoRefreshAuthenticationProvider(credentials);

    assertEquals(expiredResponse.getApiToken(), authenticationProvider.getAuthorizationToken(client));

    ApiAuthenticationResponse newResponse = new ApiAuthenticationResponse();
    newResponse.setApiToken("test-token-2");
    newResponse.setExpiresTime(ZonedDateTime.of(10_000, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")));

    when(client.execute(any(ApiAuthenticationRequest.class))).thenReturn(newResponse);

    assertEquals(newResponse.getApiToken(), authenticationProvider.getAuthorizationToken(client));
    verify(client, times(2)).execute(any(ApiAuthenticationRequest.class));
  }

}