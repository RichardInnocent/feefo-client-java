package org.richardinnocent.feefo.api.v10.reviews.shared.params;

public enum EmptyProductCommentInclusion {
  INJECT_DEFAULT_COMMENT("default"),
  INCLUDE("include"),
  EXCLUDE("exclude");

  private final String queryKey;

  EmptyProductCommentInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  public String getQueryKey() {
    return queryKey;
  }
}
