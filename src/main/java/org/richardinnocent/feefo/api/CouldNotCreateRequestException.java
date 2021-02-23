package org.richardinnocent.feefo.api;

/**
 * Indicates that the request was never executed due to configuration issues that caused the request
 * creation process to fail.
 */
public class CouldNotCreateRequestException extends FeefoApiRequestFailedException {

  /**
   * Creates a new exception to indicate that a request was never executed due to configuration
   * issues that caused the request creation process to fail.
   * @param message The exception message.
   */
  public CouldNotCreateRequestException(String message) {
    super(message);
  }

  /**
   * Creates a new exception to indicate that a request was never executed due to configuration
   * issues that caused the request creation process to fail.
   * @param cause The cause of the exception.
   */
  public CouldNotCreateRequestException(Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new exception to indicate that a request was never executed due to configuration
   * issues that caused the request creation process to fail.
   * @param message The exception message.
   * @param cause The cause of the exception.
   */
  public CouldNotCreateRequestException(String message, Throwable cause) {
    super(message, cause);
  }

}
