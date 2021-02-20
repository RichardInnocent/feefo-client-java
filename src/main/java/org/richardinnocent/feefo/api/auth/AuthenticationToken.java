package org.richardinnocent.feefo.api.auth;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * The authentication token that the Feefo API requires to authenticate requests. The token has an
 * expiration time (generally four hours after it was created).
 */
public final class AuthenticationToken {

  private final String token;
  private final OffsetDateTime expirationTime;

  private AuthenticationToken(String token, OffsetDateTime expirationTime)
      throws NullPointerException {
    this.token = Objects.requireNonNull(token, "Token must be set");
    this.expirationTime = Objects.requireNonNull(expirationTime, "Expiration time must be set");
  }

  /**
   * Gets the authentication token.
   * @return The authentication token.
   */
  public String getToken() {
    return token;
  }

  /**
   * Gets the time at which the authentication token expires.
   * @return The time at which the authentication token expires.
   */
  public OffsetDateTime getExpirationTime() {
    return expirationTime;
  }

  /**
   * Checks whether this token has expired, i.e. the current time is equal to or after the
   * expiration time.
   * @return {@code true} if the token has expired.
   */
  public boolean hasExpired() {
    return expirationTime.compareTo(OffsetDateTime.now()) < 0;
  }

  /**
   * Creates a new authentication token.
   * @param token The authentication token as it should appear in the request headers.
   * @param expirationTime The time that the token expires.
   * @return A new authentication token.
   * @throws NullPointerException Thrown if {@code token == null} or {@code expirationTime == null}.
   */
  public static AuthenticationToken of(String token, OffsetDateTime expirationTime)
      throws NullPointerException {
    return new AuthenticationToken(token, expirationTime);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationToken that = (AuthenticationToken) o;
    return Objects.equals(token, that.token) && Objects
        .equals(expirationTime, that.expirationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, expirationTime);
  }
}
