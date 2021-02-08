package org.richardinnocent.feefo.api.v10.reviews.all.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class SimpleCustomer {

  @JsonProperty("display_name")
  private String displayName;

  @JsonProperty("display_location")
  private String displayLocation;

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayLocation() {
    return displayLocation;
  }

  public void setDisplayLocation(String displayLocation) {
    this.displayLocation = displayLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleCustomer customer = (SimpleCustomer) o;
    return Objects.equals(displayName, customer.displayName)
        && Objects.equals(displayLocation, customer.displayLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, displayLocation);
  }

}
