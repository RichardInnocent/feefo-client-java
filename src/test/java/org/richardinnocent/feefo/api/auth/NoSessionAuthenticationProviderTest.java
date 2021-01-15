package org.richardinnocent.feefo.api.auth;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.client.FeefoApiClient;

public class NoSessionAuthenticationProviderTest {

  @Test
  public void getAuthenticationToken_Always_ReturnsNull() {
    assertNull(
        NoSessionAuthenticationProvider
            .getInstance().getAuthenticationToken(mock(FeefoApiClient.class))
    );
  }

}