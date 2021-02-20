package org.richardinnocent.feefo.api;

public class CouldNotCreateRequestException extends FeefoApiRequestFailedException {

  public CouldNotCreateRequestException(String message) {
    super(message);
  }

  public CouldNotCreateRequestException(Throwable cause) {
    super(cause);
  }

  public CouldNotCreateRequestException(String message, Throwable cause) {
    super(message, cause);
  }

}
