package org.richardinnocent.feefo.api.auth.request;

import java.time.LocalDateTime;
import java.util.Objects;

public class ApiAuthenticationResponse {

  private String apiToken;
  private LocalDateTime expiresTime;

  public String getApiToken() {
    return apiToken;
  }

  public void setApiToken(String apiToken) {
    this.apiToken = apiToken;
  }

  public LocalDateTime getExpiresTime() {
    return expiresTime;
  }

  public void setExpiresTime(LocalDateTime expiresTime) {
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
