package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Contains details on a customer.
 */
public class SimpleCustomer {

  @JsonProperty("display_name")
  private String displayName;

  @JsonProperty("display_location")
  private String displayLocation;

  /**
   * Gets the name that the customer chose to display publicly.
   * @return The customer's chosen display name.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the name that the customer chose to display publicly.
   * @param displayName The customer's chosen display name.
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * Gets the location that the customer chose to display publicly.
   * @return The customer's chosen display location.
   */
  public String getDisplayLocation() {
    return displayLocation;
  }

  /**
   * Sets the location that the customer chose to display publicly.
   * @param displayLocation The customer's chosen display location.
   */
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
