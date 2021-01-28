package org.richardinnocent.feefo.api;

/**
 * Exception thrown if the request is unauthorised. This may be thrown after or before sending a
 * request - if this library determines that the request requires authorisation but none is
 * provided, this exception will be thrown. Equally, if the server responds with a {@code 401}
 * response code, this will be thrown.
 */
public class UnauthorisedException extends FeefoApiRequestFailedException {

  /**
   * Creates a new exception with the given message.
   * @param message The exception message.
   */
  public UnauthorisedException(String message) {
    super(message);
  }

  /**
   * Creates a new exception with the given cause.
   * @param cause The cause of the exception.
   */
  public UnauthorisedException(Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new exception with the given message and cause.
   * @param message The exception message.
   * @param cause The cause of the exception.
   */
  public UnauthorisedException(String message, Throwable cause) {
    super(message, cause);
  }

}
