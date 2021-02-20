package org.richardinnocent.feefo.api.v10.reviews.shared.params;

public enum TimeFrame {
  LAST_24_HOURS("24_hours"),
  LAST_WEEK("week"),
  LAST_30_DAYS("month"),
  LAST_YEAR("year"),
  ALL("all");

  private final String queryKey;

  TimeFrame(String queryKey) {
    this.queryKey = queryKey;
  }

  public String getQueryKey() {
    return queryKey;
  }
}
