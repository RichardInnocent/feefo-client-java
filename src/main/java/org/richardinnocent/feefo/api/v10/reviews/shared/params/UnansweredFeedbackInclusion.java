package org.richardinnocent.feefo.api.v10.reviews.shared.params;

public enum UnansweredFeedbackInclusion {
  INCLUDE("include"),
  EXCLUDE("exclude"),
  EXCLUDE_NEGATIVE("exclude_negative");

  private final String queryKey;

  UnansweredFeedbackInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  public String getQueryKey() {
    return queryKey;
  }
}
