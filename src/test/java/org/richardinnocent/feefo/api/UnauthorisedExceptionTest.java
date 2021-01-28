package org.richardinnocent.feefo.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class UnauthorisedExceptionTest {

  @Test
  public void messageConstructor_Always_MessageSet() {
    String message = "Test message";
    assertEquals(message, new UnauthorisedException(message).getMessage());
  }

  @Test
  public void causeConstructor_Always_CauseSet() {
    Throwable cause = mock(Throwable.class);
    assertEquals(cause, new UnauthorisedException(cause).getCause());
  }

  @Test
  public void messageAndCauseConstructor_Always_MessageAndCauseSet() {
    String message = "Test message";
    Throwable cause = mock(Throwable.class);
    Exception exception = new UnauthorisedException(message, cause);
    assertEquals(message, exception.getMessage());
    assertEquals(cause, exception.getCause());
  }

}