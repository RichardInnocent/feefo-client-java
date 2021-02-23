package org.richardinnocent.feefo.api.v10.reviews.shared.params;

/**
 * Specifies how feedback left over the last 48 hours without a response from the merchant are
 * returned.
 */
public enum UnansweredFeedbackInclusion {

  /**
   * All feedback is returned, regardless of whether the merchant has responded.
   */
  INCLUDE("include"),

  /**
   * Feedback left over the last 48 hours that has not yet received a response from the merchant are
   * excluded.
   */
  EXCLUDE("exclude"),

  /**
   * Feedback that received a 1 or 2-star rating that has not yet received a response from the
   * merchant are excluded. The exact behaviour depends on the context:
   * <table>
   *   <tr>
   *     <th>Mode</th>
   *     <th>Effect</th>
   *   </tr>
   *   <tr>
   *     <td>All</td>
   *     <td>The entire feedback will be suppressed if any element of the feedback is negative and
   *     there is no merchant reply against the service element or the negative product element.
   *     </td>
   *   </tr>
   *   <tr>
   *     <td>Service</td>
   *     <td>The feedback will be suppressed if the service feedback is negative and there's no
   *     merchant reply.</td>
   *   </tr>
   *   <tr>
   *     <td>Product</td>
   *     <td>The feedback will be suppressed if the product feedback is negative and there's no
   *     merchant reply.</td>
   *   </tr>
   * </table>
   */
  EXCLUDE_NEGATIVE("exclude_negative");

  private final String queryKey;

  UnansweredFeedbackInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  /**
   * Gets the value as it should appear in API requests.
   * @return The value as it should appear in API requests.
   */
  public String getQueryValue() {
    return queryKey;
  }
}
