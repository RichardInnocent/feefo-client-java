package org.richardinnocent.feefo.api.v10.reviews.all.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class EnrichedCustomer {

  @JsonProperty("display_name")
  private String displayName;

  @JsonProperty("display_location")
  private String displayLocation;

  private String name;

  private String email;

  @JsonProperty("mobile")
  private String mobileNumber;

  @JsonProperty("order_ref")
  private String orderReference;

  @JsonProperty("customer_ref")
  private String customerReference;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getOrderReference() {
    return orderReference;
  }

  public void setOrderReference(String orderReference) {
    this.orderReference = orderReference;
  }

  public String getCustomerReference() {
    return customerReference;
  }

  public void setCustomerReference(String customerReference) {
    this.customerReference = customerReference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrichedCustomer customer = (EnrichedCustomer) o;
    return Objects.equals(displayName, customer.displayName)
        && Objects.equals(displayLocation, customer.displayLocation)
        && Objects.equals(name, customer.name)
        && Objects.equals(email, customer.email)
        && Objects.equals(mobileNumber, customer.mobileNumber)
        && Objects.equals(orderReference, customer.orderReference)
        && Objects.equals(customerReference, customer.customerReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        displayName, displayLocation, name, email, mobileNumber, orderReference, customerReference
    );
  }
}