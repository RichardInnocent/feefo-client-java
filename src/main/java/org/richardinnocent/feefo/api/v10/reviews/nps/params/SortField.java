package org.richardinnocent.feefo.api.v10.reviews.nps.params;

/**
 * Specifies the field that the results will be sorted by.
 */
public enum SortField {

  /**
   * Sort by the date that the feedback was created.
   */
  FEEDBACK_CREATION_TIME("created_date"),

  /**
   * Sorted by the date that the feedback was last updated.
   */
  FEEDBACK_UPDATED_TIME("updated_date");

  private final String queryValue;

  SortField(String queryValue) {
    this.queryValue = queryValue;
  }

  /**
   * Gets the name of the field as it should appear in the API call.
   * @return The name of the field as it should appear in the API call.
   */
  public String getQueryKey() {
    return queryValue;
  }
}
