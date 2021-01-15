package org.richardinnocent.feefo.api.auth.request;

import java.util.Objects;

/**
 * The authentication request that is sent to the Feefo API.
 */
public class ApiAuthenticationRequestDto {

  private String merchantIdentifier;
  private String apiKey;
  private String username;
  private String password;

  /**
   * Gets the unique identifier for the merchant.
   * @return The unique identifier for the merchant.
   */
  public String getMerchantIdentifier() {
    return merchantIdentifier;
  }

  /**
   * Sets the unique identifier for the merchant.
   * @param merchantIdentifier The unique identifier for the merchant.
   */
  public void setMerchantIdentifier(String merchantIdentifier) {
    this.merchantIdentifier = merchantIdentifier;
  }

  /**
   * Gets the API key for the merchant.
   * @return The API key for the merchant.
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Sets the API key for the merchant.
   * @param apiKey The API key for the merchant.
   */
  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   * Gets the username for the user that is used to authenticate.
   * @return The username for the user that is used to authenticate.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username for the user that is used to authenticate.
   * @param username The username for the user that is used to authenticate.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets the password for the user that is used to authenticate.
   * @return The password for the user that is used to authenticate.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password for the user that is used to authenticate.
   * @param password The password for the user that is used to authenticate.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiAuthenticationRequestDto that = (ApiAuthenticationRequestDto) o;
    return Objects.equals(merchantIdentifier, that.merchantIdentifier) && Objects
        .equals(apiKey, that.apiKey) && Objects.equals(username, that.username)
        && Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantIdentifier, apiKey, username, password);
  }
}
