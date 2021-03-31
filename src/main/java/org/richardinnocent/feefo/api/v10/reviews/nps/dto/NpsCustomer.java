package org.richardinnocent.feefo.api.v10.reviews.nps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class NpsCustomer {

  private String name;

  private String email;

  @JsonProperty("mobile")
  private String mobileNumber;

  @JsonProperty("order_ref")
  private String orderReference;

  @JsonProperty("customer_ref")
  private String customerReference;

  /**
   * Gets the customer's name. This is the name provided by the merchant when submitting a sale.
   * @return The customer's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the customer's name. This is the name provided by the merchant when submitting a sale.
   * @param name The customer's name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the customer's email address.
   * @return The customer's email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the customer's email address.
   * @param email The customer's email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the customer's mobile number.
   * @return The customer's mobile number.
   */
  public String getMobileNumber() {
    return mobileNumber;
  }

  /**
   * Sets the customer's mobile number.
   * @param mobileNumber The customer's mobile number.
   */
  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  /**
   * Gets the order reference.
   * @return The order reference.
   */
  public String getOrderReference() {
    return orderReference;
  }

  /**
   * Sets the order reference.
   * @param orderReference The order reference.
   */
  public void setOrderReference(String orderReference) {
    this.orderReference = orderReference;
  }

  /**
   * Gets the customer reference.
   * @return The customer reference.
   */
  public String getCustomerReference() {
    return customerReference;
  }

  /**
   * Sets the customer reference.
   * @param customerReference The customer reference.
   */
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
    NpsCustomer that = (NpsCustomer) o;
    return Objects.equals(name, that.name) && Objects.equals(email, that.email)
        && Objects.equals(mobileNumber, that.mobileNumber) && Objects
        .equals(orderReference, that.orderReference) && Objects
        .equals(customerReference, that.customerReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, mobileNumber, orderReference, customerReference);
  }
}
