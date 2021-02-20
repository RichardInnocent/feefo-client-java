package org.richardinnocent.feefo.api.v10.reviews.shared.params;

public enum MediaInclusion {
  INCLUDE("include"),
  EXCLUDE("exclude"),
  MUST_HAVE_MEDIA("only"),
  MUST_HAVE_VIDEO("video"),
  MUST_HAVE_PHOTO("photo");

  private final String queryKey;

  MediaInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  public String getQueryKey() {
    return queryKey;
  }
}
