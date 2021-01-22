package org.richardinnocent.feefo.api.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.UnauthorisedException;
import org.richardinnocent.feefo.api.auth.AuthenticationProvider;
import org.richardinnocent.feefo.api.auth.NoSessionAuthenticationProvider;
import org.richardinnocent.feefo.api.mapping.FeefoApiObjectMapper;

class FeefoApiClientImplTest {

  @Test
  public void defaultConstructor_Always_FieldsAreSetAppropriately() throws Exception {
    FeefoApiClientImpl client = new FeefoApiClientImpl();
    assertEquals("https://api.feefo.com/api", client.getBaseUrl());
    assertTrue(getAuthenticationProvider(client) instanceof NoSessionAuthenticationProvider);
    assertTrue(getObjectMapper(client) instanceof FeefoApiObjectMapper);
  }

  @Test
  public void authenticationProviderConstructor_ProviderNotNull_FieldsAreSetAppropriately()
      throws Exception {
    AuthenticationProvider authenticationProvider = mock(AuthenticationProvider.class);
    FeefoApiClientImpl client = new FeefoApiClientImpl(authenticationProvider);
    assertEquals("https://api.feefo.com/api", client.getBaseUrl());
    assertEquals(authenticationProvider, getAuthenticationProvider(client));
    assertTrue(getObjectMapper(client) instanceof FeefoApiObjectMapper);
  }

  @Test
  public void authenticationProviderConstructor_ProviderNull_NoSessionProviderUsed()
      throws Exception {
    FeefoApiClientImpl client = new FeefoApiClientImpl(null);
    assertEquals("https://api.feefo.com/api", client.getBaseUrl());
    assertTrue(getAuthenticationProvider(client) instanceof NoSessionAuthenticationProvider);
    assertTrue(getObjectMapper(client) instanceof FeefoApiObjectMapper);
  }

  @Test
  public void fullConstructor_ValidValues_FieldAreSetAppropriately() throws Exception {
    String baseUrl = "https://testbaseurl.com";
    AuthenticationProvider authenticationProvider = mock(AuthenticationProvider.class);
    ObjectMapper objectMapper = mock(ObjectMapper.class);

    FeefoApiClientImpl client =
        new FeefoApiClientImpl(baseUrl, authenticationProvider, objectMapper);

    assertEquals(baseUrl, client.getBaseUrl());
    assertEquals(authenticationProvider, getAuthenticationProvider(client));
    assertEquals(objectMapper, getObjectMapper(client));
  }

  @Test
  public void fullConstructor_BaseUrlIsNull_ExceptionThrown() {
    try {
      new FeefoApiClientImpl(null, mock(AuthenticationProvider.class), mock(ObjectMapper.class));
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Base URL is null", e.getMessage());
    }
  }

  @Test
  public void fullConstructor_AuthenticationProviderIsNull_NoSessionProviderIsUsed()
      throws Exception {
    FeefoApiClientImpl client =
        new FeefoApiClientImpl("https://testbaseurl.com", null, mock(ObjectMapper.class));

    assertTrue(getAuthenticationProvider(client) instanceof NoSessionAuthenticationProvider);
  }

  @Test
  public void fullConstructor_ObjectMapperIsNull_ExceptionThrown() {
    try {
      new FeefoApiClientImpl("https://testbaseurl.com", mock(AuthenticationProvider.class), null);
      fail("No exception thrown");
    } catch (NullPointerException e) {
      assertEquals("Object mapper is null", e.getMessage());
    }
  }

  @Test
  public void configureAuthentication_AuthorizationTokenIsNull_ExceptionThrown() {
    try {
      new FeefoApiClientImpl().configureAuthentication(mock(HttpURLConnection.class));
    } catch (UnauthorisedException e) {
      assertEquals(
          "Authentication is required for this service, but no authentication has been provided to "
              + "the service",
          e.getMessage()
      );
    }
  }

  @Test
  public void configureAuthentication_AuthorizationTokenIsPresent_TokenAddedToHeader() {
    String token = "test-authorization-token";
    AuthenticationProvider provider = mock(AuthenticationProvider.class);
    when(provider.getAuthorizationToken(any())).thenReturn(token);

    HttpURLConnection connection = mock(HttpURLConnection.class);

    new FeefoApiClientImpl(provider).configureAuthentication(connection);
    verify(connection, times(1)).setRequestProperty("Authorization", token);
  }

  private static AuthenticationProvider getAuthenticationProvider(FeefoApiClientImpl client)
      throws NoSuchFieldException, IllegalAccessException {
    return (AuthenticationProvider) getField(client, "authenticationProvider");
  }

  private static ObjectMapper getObjectMapper(FeefoApiClientImpl client)
      throws NoSuchFieldException, IllegalAccessException {
    return (ObjectMapper) getField(client, "objectMapper");
  }

  private static Object getField(FeefoApiClientImpl client, String fieldName)
      throws NoSuchFieldException, IllegalAccessException {
    Field field = client.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    Object result = field.get(client);
    field.setAccessible(false);
    return result;
  }

}