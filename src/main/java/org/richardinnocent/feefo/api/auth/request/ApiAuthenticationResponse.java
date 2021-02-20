package org.richardinnocent.feefo.api.auth.request;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * The authentication repsonse from the Feefo API. This consists of an API token that should be sent
 * with each subsequent request that requires authentication, and the expiration time of that token.
 */
public class ApiAuthenticationResponse {

  private String apiToken;
  private ZonedDateTime expiresTime;

  /**
   * Gets the API token that can be sent with subsequent requests to authenticate.
   * @return The API token that can be sent with subsequent requests to authenticate.
   */
  public String getApiToken() {
    return apiToken;
  }

  /**
   * Sets the API token that can be sent with subsequent requests to authenticate.
   * @param apiToken The API token that can be sent with subsequent requests to authenticate.
   */
  public void setApiToken(String apiToken) {
    this.apiToken = apiToken;
  }

  /**
   * Gets the expiration time of the token.
   * @return The expiration time of the token.
   */
  public ZonedDateTime getExpiresTime() {
    return expiresTime;
  }

  /**
   * Sets the expiration time of the token.
   * @param expiresTime The expiration time of the token.
   */
  public void setExpiresTime(ZonedDateTime expiresTime) {
    this.expiresTime = expiresTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiAuthenticationResponse that = (ApiAuthenticationResponse) o;
    return Objects.equals(apiToken, that.apiToken) && Objects
        .equals(expiresTime, that.expiresTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiToken, expiresTime);
  }
}
