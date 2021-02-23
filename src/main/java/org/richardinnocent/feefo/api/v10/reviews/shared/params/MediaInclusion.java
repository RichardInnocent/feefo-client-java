package org.richardinnocent.feefo.api.v10.reviews.shared.params;

/**
 * Defines how reviews with media should be handled in the response.
 */
public enum MediaInclusion {

  /**
   * All reviews shall be returned, regardless of whether they contain media.
   */
  INCLUDE("include"),

  /**
   * Only reviews without media shall be returned.
   */
  EXCLUDE("exclude"),

  /**
   * Only reviews with media shall be returned.
   */
  MUST_HAVE_MEDIA("only"),

  /**
   * Only reviews with video media shall be returned.
   */
  MUST_HAVE_VIDEO("video"),

  /**
   * Only reviews with photo media shall be returned.
   */
  MUST_HAVE_PHOTO("photo");

  private final String queryKey;

  MediaInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  /**
   * Gets the value as it should appear in the API request.
   * @return The value as it should appear in the API request.
   */
  public String getQueryValue() {
    return queryKey;
  }
}
