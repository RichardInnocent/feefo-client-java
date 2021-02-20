package org.richardinnocent.feefo.api.v10.reviews.shared.params;

public enum Inclusion {
  INCLUDE("include"),
  EXCLUDE("exclude");

  private final String queryKey;

  Inclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  public String getQueryKey() {
    return queryKey;
  }
}
