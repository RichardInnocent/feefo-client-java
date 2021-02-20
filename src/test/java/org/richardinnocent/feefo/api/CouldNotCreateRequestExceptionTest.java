package org.richardinnocent.feefo.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class CouldNotCreateRequestExceptionTest {

  @Test
  public void messageConstructor_Always_SetsMessage() {
    String message = "Test message";
    assertEquals(message, new CouldNotCreateRequestException(message).getMessage());
  }

  @Test
  public void causeConstructor_Always_SetsCause() {
    Throwable cause = mock(Throwable.class);
    assertEquals(cause, new CouldNotCreateRequestException(cause).getCause());
  }

  @Test
  public void messageAndCauseConstructor_Always_SetsMessageAndCause() {
    String message = "Test message";
    Throwable cause = mock(Throwable.class);
    Throwable exception = new CouldNotCreateRequestException(message, cause);
    assertEquals(message, exception.getMessage());
    assertEquals(cause, exception.getCause());
  }

}