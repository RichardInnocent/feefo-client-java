package org.richardinnocent.feefo.api;

/**
 * This exception is thrown if there is an error communicating with the Feefo API. This could be
 * thrown at various stages, e.g.
 * <ul>
 *   <li>The request isn't properly configured or is malformed so is never sent.</li>
 *   <li>There are problems sending the request - the API could be unavailable.</li>
 *   <li>There are problems retrieving the response - the API may respond with an unexpected
 *   response structure, or there is a problem reading the result.</li>
 *   <li>The API responds with an error code.</li>
 * </ul>
 */
public class FeefoApiRequestFailedException extends RuntimeException {

  /**
   * Creates a new exception with the given message.
   * @param message The exception message.
   */
  public FeefoApiRequestFailedException(String message) {
    super(message);
  }

  /**
   * Creates a new exception with the given cause.
   * @param cause The cause of the exception.
   */
  public FeefoApiRequestFailedException(Throwable cause) {
    super(cause);
  }

  /**
   * Creates a new exception with the given message and cause.
   * @param message The exception message.
   * @param cause The cause of the exception.
   */
  public FeefoApiRequestFailedException(String message, Throwable cause) {
    super(message, cause);
  }

}
