package org.richardinnocent.feefo.api.auth;

import java.util.Objects;
import org.richardinnocent.feefo.api.auth.ApiCredentials.Builder.FinalStageBuilder;
import org.richardinnocent.feefo.api.auth.request.ApiAuthenticationRequest;

/**
 * Contains the credentials that are used to authenticate the user and receive a valid
 * authentication header that can then be used to authenticate subsequent requests if required. The
 * authentication is valid for a merchant and (most likely) all of its sub-merchants. The
 * authentication process requires four pieces of information, namely:
 * <ul>
 *   <li><b>Merchant identifier</b>: The unique identifier for the merchant.</li>
 *   <li><b>API key</b>: The API for the given merchant.</li>
 *   <li><b>Username</b>: The username (probably the email address) for a merchant admin user tied
 *   to the specified account. Feefo recommends adding a dedicated user account specifically to be
 *   used to authenticate API requests.</li>
 *   <li><b>Password</b>: The password for the aforementioned user.</li>
 * </ul>
 * More details can be found on the
 * <a href="https://support.feefo.com/support/solutions/articles/8000041717-api-authentication">API documentation page</a>.
 */
public class ApiCredentials {

  private final String merchantIdentifier;
  private final String apiKey;
  private final String username;
  private final String password;

  private ApiCredentials(FinalStageBuilder builder) {
    this.merchantIdentifier = builder.merchantIdentifier;
    this.apiKey = builder.apiKey;
    this.username = builder.username;
    this.password = builder.password;
  }

  /**
   * Gets the unique identifier for the merchant.
   * @return The unique identifier for the merchant.
   */
  public String getMerchantIdentifier() {
    return merchantIdentifier;
  }

  /**
   * Gets the API key for the merchant.
   * @return The API key for the merchant.
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Gets the username for the user that will be used to authorise the requests.
   * @return The username for the user that will be used to authorise the requests.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the password for the user that will be used to authorise the requests.
   * @return The password for the user that will be used to authorise the requests.
   */
  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiCredentials that = (ApiCredentials) o;
    return Objects.equals(merchantIdentifier, that.merchantIdentifier) && Objects
        .equals(apiKey, that.apiKey) && Objects.equals(username, that.username)
        && Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantIdentifier, apiKey, username, password);
  }

  /**
   * Creates a new builder for {@link ApiCredentials} objects.
   * @return A new builder.
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder for {@link ApiCredentials} objects.
   */
  public static class Builder {
    private Builder() {}

    /**
     * Specifies the merchant identifier. The merchant identifier is the merchant's unique
     * identifier, and can be found in the Hub. More information on finding the appropriate
     * merchant identifier can be found
     * <a href="https://support.feefo.com/support/solutions/articles/8000037204-where-to-find-my-merchant-identifier-">here</a>.
     * Note that authenticating for a parent merchant may also provide access to all of its
     * sub-merchants, meaning that only one authentication token needs to be maintained in the
     * majority of cases.
     * @param merchantIdentifier The merchant's unique identifier.
     * @return A builder.
     * @throws NullPointerException Thrown if {@code merchantIdentifier == null}.
     * @throws IllegalArgumentException Thrown if {@code merchantIdentifier.isEmpty()}.
     */
    public FirstStageBuilder forMerchantIdentifier(String merchantIdentifier)
        throws NullPointerException, IllegalArgumentException {
      return new FirstStageBuilder(merchantIdentifier);
    }

    /**
     * Builder for {@link ApiAuthenticationRequest} objects.
     */
    public static class FirstStageBuilder {
      private final String merchantIdentifier;

      private FirstStageBuilder(String merchantIdentifier)
          throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(
            merchantIdentifier, "Merchant identifier should be specified but is null"
        );
        if (merchantIdentifier.isEmpty()) {
          throw new IllegalArgumentException(
              "Merchant identifier should be specified but is empty"
          );
        }
        this.merchantIdentifier = merchantIdentifier;
      }

      /**
       * Specifies the merchant's API key. You can find more information about finding your API key
       * <a href="https://support.feefo.com/support/solutions/articles/8000041717-api-authentication">here</a>.
       * @param apiKey The merchant's API key.
       * @return A builder.
       * @throws NullPointerException Thrown if {@code apiKey == null}.
       * @throws IllegalArgumentException Thrown if {@code apiKey.isEmpty()}.
       */
      public SecondStageBuilder withApiKey(String apiKey)
          throws NullPointerException, IllegalArgumentException {
        return new SecondStageBuilder(apiKey, this);
      }
    }

    /**
     * Builder for {@link ApiAuthenticationRequest} objects.
     */
    public static class SecondStageBuilder {
      private final String merchantIdentifier;
      private final String apiKey;

      private SecondStageBuilder(String apiKey, FirstStageBuilder previousBuilder)
          throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(apiKey, "An API key should be specified but is null");
        if (apiKey.isEmpty()) {
          throw new IllegalArgumentException("An API key should be specified but is empty");
        }
        this.merchantIdentifier = previousBuilder.merchantIdentifier;
        this.apiKey = apiKey;
      }

      /**
       * Specifies the username of the merchant admin user that will be used to authenticate the
       * requests. The
       * <a href="https://support.feefo.com/support/solutions/articles/8000041717-api-authentication">API authentication documentation</a>
       * suggests the creation of a dedicated user account for this purpose.
       * @param username The user's username (most likely their email address).
       * @return A builder.
       * @throws NullPointerException Thrown if {@code username == null}.
       * @throws IllegalArgumentException Thrown if {@code username.isEmpty()}.
       */
      public ThirdStageBuilder withUsername(String username)
          throws NullPointerException, IllegalArgumentException {
        return new ThirdStageBuilder(username, this);
      }
    }

    /**
     * Builder for {@link ApiAuthenticationRequest} instances.
     */
    public static class ThirdStageBuilder {
      private final String merchantIdentifier;
      private final String apiKey;
      private final String username;

      private ThirdStageBuilder(String username, SecondStageBuilder previousBuilder)
          throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(
            username,
            "The credentials for a merchant admin Feefo account must be used to authenticate the "
                + "requests, but the provided username is null"
        );
        if (username.isEmpty()) {
          throw new IllegalArgumentException(
              "The credentials for a merchant admin Feefo account must be used to authenticate the "
                  + "requests, but the provided username is empty"
          );
        }
        this.merchantIdentifier = previousBuilder.merchantIdentifier;
        this.apiKey = previousBuilder.apiKey;
        this.username = username;
      }

      /**
       * Specifies the password for the user.
       * @param password The password for the user.
       * @return A builder.
       * @throws NullPointerException Thrown if {@code password == null}.
       * @throws IllegalArgumentException Thrown if {@code password.isEmpty()}.
       */
      public FinalStageBuilder withPassword(String password)
          throws NullPointerException, IllegalArgumentException {
        return new FinalStageBuilder(password, this);
      }
    }

    /**
     * Final stage builder for {@link ApiAuthenticationRequest} objects.
     */
    public static class FinalStageBuilder {
      private final String merchantIdentifier;
      private final String apiKey;
      private final String username;
      private final String password;

      private FinalStageBuilder(String password, ThirdStageBuilder previousBuilder)
          throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(
            password,
            "The credentials for a merchant admin Feefo account must be used to authenticate the "
                + "requests, but the provided password is null"
        );
        if (password.isEmpty()) {
          throw new IllegalArgumentException(
              "The credentials for a merchant admin Feefo account must be used to authenticate the "
                  + "requests, but the provided password is empty"
          );
        }
        this.merchantIdentifier = previousBuilder.merchantIdentifier;
        this.apiKey = previousBuilder.apiKey;
        this.username = previousBuilder.username;
        this.password = password;
      }

      /**
       * Builds the {@link ApiCredentials}.
       * @return The credentials.
       */
      public ApiCredentials build() {
        return new ApiCredentials(this);
      }
    }
  }

}
