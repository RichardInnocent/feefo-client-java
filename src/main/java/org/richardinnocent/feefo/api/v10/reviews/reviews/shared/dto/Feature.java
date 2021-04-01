package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import java.util.Objects;

/**
 * Contains details for any prominent feature of the review content.
 */
public class Feature {

  private String text;
  private Double score;

  /**
   * The feature text that was highlighted.
   * @return The feature text that was highlighted.
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the feature text that was highlighted.
   * @param text The feature text that was highlighted/
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets the score associated with the feature. The score will be between -1.0 and 1.0 (inclusive),
   * where a score of 1.0 indicates a very positive sentiment towards the feature.
   * @return The score associated with the feature.
   */
  public Double getScore() {
    return score;
  }

  /**
   * Sets the score associated with the feature. The score should be between -1.0 and 1.0
   * (inclusive), where a score of 1.0 indicates a very positive sentiment towards the feature.
   * @param score The score associated with the feature.
   */
  public void setScore(Double score) {
    this.score = score;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Feature feature = (Feature) o;
    return Objects.equals(score, feature.score) && Objects.equals(text, feature.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, score);
  }
}
