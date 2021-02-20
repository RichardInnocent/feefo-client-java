package org.richardinnocent.feefo.api.v10.reviews.all.params;

public enum SortField {
  FEEDBACK_CREATION_TIME("created_date"),
  FEEDBACK_UPDATED_TIME("updated_date"),
  HELPFUL_VOTES("helpful"),
  SERVICE_FEEDBACK_ID("id");

  private final String queryValue;

  SortField(String queryValue) {
    this.queryValue = queryValue;
  }

  public String getQueryKey() {
    return queryValue;
  }
}
