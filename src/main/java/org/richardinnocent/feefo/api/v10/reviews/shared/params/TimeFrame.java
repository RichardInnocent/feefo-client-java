package org.richardinnocent.feefo.api.v10.reviews.shared.params;

/**
 * Specifies a particular time frame over which a feedback search should occur.
 */
public enum TimeFrame {

  /**
   * The search will only consider feedback from the last 24 hours.
   */
  LAST_24_HOURS("24_hours"),

  /**
   * The search will only consider feedback from the seven days.
   */
  LAST_WEEK("week"),

  /**
   * The search will only consider feedback from the last 30 days.
   */
  LAST_30_DAYS("month"),

  /**
   * The search will only consider feedback from the last 365 days.
   */
  LAST_YEAR("year"),

  /**
   * The search will consider all feedback, irrespective of when the feedback was received.
   */
  ALL("all");

  private final String queryKey;

  TimeFrame(String queryKey) {
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
