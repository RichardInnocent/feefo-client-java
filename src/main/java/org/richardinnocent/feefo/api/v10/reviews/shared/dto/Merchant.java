package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import java.util.Objects;

/**
 * Contains details on the merchant.
 */
public class Merchant {

  private String identifier;

  /**
   * Gets the identifier of the merchant. This will be {@code null} if the request is not set to
   * include sub merchants.
   * @return The identifier of the merchant.
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Sets the identifier of the merchant.
   * @param identifier The identifier of the merchant.
   */
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Merchant merchant = (Merchant) o;
    return Objects.equals(identifier, merchant.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier);
  }
}
