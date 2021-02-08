package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import java.util.Objects;

public class Merchant {

  private String identifier;

  public String getIdentifier() {
    return identifier;
  }

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
