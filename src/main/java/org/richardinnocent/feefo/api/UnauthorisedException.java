package org.richardinnocent.feefo.api;

public class UnauthorisedException extends FeefoApiRequestFailedException {

  public UnauthorisedException(String message) {
    super(message);
  }

  public UnauthorisedException(Throwable cause) {
    super(cause);
  }

  public UnauthorisedException(String message, Throwable cause) {
    super(message, cause);
  }

}
