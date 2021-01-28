package org.richardinnocent.feefo.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class FeefoApiRequestFailedExceptionTest {

  @Test
  public void messageConstructor_Always_SetsMessageCorrectly() {
    String message = "Test message";
    assertEquals(message, new FeefoApiRequestFailedException(message).getMessage());
  }

  @Test
  public void causeConstructor_Always_SetsCauseCorrectly() {
    Throwable cause = mock(Throwable.class);
    assertEquals(cause, new FeefoApiRequestFailedException(cause).getCause());
  }

  @Test
  public void messageAndCauseConstructor_Always_SetsMessageAndCauseCorrectly() {
    String message = "Test message";
    Throwable cause = mock(Throwable.class);
    Exception exception = new FeefoApiRequestFailedException(message, cause);
    assertEquals(message, exception.getMessage());
    assertEquals(cause, exception.getCause());
  }

}