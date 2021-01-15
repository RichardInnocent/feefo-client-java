package org.richardinnocent.feefo.api.auth;

import java.time.LocalDateTime;
import java.util.Objects;

public final class AuthenticationToken {

  private final String token;
  private final LocalDateTime expirationTime;

  private AuthenticationToken(String token, LocalDateTime expirationTime)
      throws NullPointerException {
    this.token = Objects.requireNonNull(token, "Token must be set");
    this.expirationTime = Objects.requireNonNull(expirationTime, "Expiration time must be set");
  }

  public String getToken() {
    return token;
  }

  public LocalDateTime getExpirationTime() {
    return expirationTime;
  }

  public boolean hasExpired() {
    return expirationTime.compareTo(LocalDateTime.now()) > 0;
  }

  public static AuthenticationToken of(String token, LocalDateTime expirationTime)
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
