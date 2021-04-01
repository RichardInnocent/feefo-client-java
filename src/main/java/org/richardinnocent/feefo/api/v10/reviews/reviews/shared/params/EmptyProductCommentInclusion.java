package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

/**
 * Specifies how product reviews with no comments should be retrieved.
 */
public enum EmptyProductCommentInclusion {
  /**
   * Returns all product feedback, even when a feedback comment has not been supplied. Feedback
   * without comments will have a default comment returned. The default comment is based on the
   * score, and will be localised based on the merchant's language preferences. For example, a
   * 5-star review for a merchant configured to use English will return "Excellent".
   */
  INJECT_DEFAULT_COMMENT("default"),

  /**
   * Returns all product feedback, even when a feedback comment has not been supplied. Feedback
   * without comments will have a {@code null} comment.
   */
  INCLUDE("include"),

  /**
   * Only returns product feedback where a feedback comment has been supplied.
   */
  EXCLUDE("exclude");

  private final String queryKey;

  EmptyProductCommentInclusion(String queryKey) {
    this.queryKey = queryKey;
  }

  /**
   * Gets the name of the value as it should appear in the API request.
   * @return The name of the value as it should appear in the API request.
   */
  public String getQueryValue() {
    return queryKey;
  }
}
