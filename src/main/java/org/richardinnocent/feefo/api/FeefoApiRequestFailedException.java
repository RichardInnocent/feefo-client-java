package org.richardinnocent.feefo.api;

public class FeefoApiRequestFailedException extends RuntimeException {

  public FeefoApiRequestFailedException(String message) {
    super(message);
  }

  public FeefoApiRequestFailedException(Throwable cause) {
    super(cause);
  }

  public FeefoApiRequestFailedException(String message, Throwable cause) {
    super(message, cause);
  }

}
