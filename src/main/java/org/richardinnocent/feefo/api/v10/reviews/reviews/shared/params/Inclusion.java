package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

/**
 * Specifies the inclusion of a particular characteristic in the response.
 */
public enum Inclusion {

  /**
   * Results that portray this characteristic shall be included in the results.
   */
  INCLUDE("include"),

  /**
   * Results that portray this characteristic shall be excluded from the results.
   */
  EXCLUDE("exclude");

  private final String queryKey;

  Inclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  /**
   * Gets the value of the parameter as it should appear in the API request.
   * @return The value of the parameter as it should appear in the API request.
   */
  public String getQueryValue() {
    return queryKey;
  }
}
