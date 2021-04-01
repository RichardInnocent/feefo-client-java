package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * <p>A sale may have been submitted with additional product "attributes" that users can rate
 * alongside their overall score. For example, when submitting a sale for a pair of shoes, the
 * merchant may request that the fit, comfort and value for money are also rated by the consumer.
 * </p>
 * <p>More information can be found
 * <a href="https://support.feefo.com/support/solutions/articles/8000039898-sales-product-file-product-attributes">here</a>.</p>
 */
public class Attribute {

  private String name;

  @JsonProperty("min")
  private double minimumAssignableScore;

  @JsonProperty("max")
  private double maximumAssignableScore;

  @JsonProperty("rating")
  private double score;

  /**
   * Gets the name of the product attribute that has been rated.
   * @return The name of the product attribute that has been rated.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the product attribute that has been rated.
   * @param name The name of the product attribute that has been rated.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the minimum score that could have been assigned to the attribute.
   * @return The minimum score that could have been assigned to the attribute.
   */
  public double getMinimumAssignableScore() {
    return minimumAssignableScore;
  }

  /**
   * Sets the minimum score that could have been assigned to the attribute.
   * @param minimumAssignableScore The minimum score that could have been assigned to the
   * attribute.
   */
  public void setMinimumAssignableScore(double minimumAssignableScore) {
    this.minimumAssignableScore = minimumAssignableScore;
  }

  /**
   * Gets the maximum score that could have been assigned to the attribute.
   * @return The maximum score that could have been assigned to the attribute.
   */
  public double getMaximumAssignableScore() {
    return maximumAssignableScore;
  }

  /**
   * Sets the maximum score that could have been assigned to the attribute.
   * @param maximumAssignableScore The maximum score that could have been assigned to the
   * attribute.
   */
  public void setMaximumAssignableScore(double maximumAssignableScore) {
    this.maximumAssignableScore = maximumAssignableScore;
  }

  /**
   * Gets the score that was assigned to the attribute.
   * @return The score that was assigned to the attribute.
   */
  public double getScore() {
    return score;
  }

  /**
   * Sets the score that was assigned to the attribute.
   * @param score The score that was assigned to the attribute.
   */
  public void setScore(double score) {
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
    Attribute attribute = (Attribute) o;
    return Double.compare(attribute.minimumAssignableScore, minimumAssignableScore) == 0
        && Double.compare(attribute.maximumAssignableScore, maximumAssignableScore) == 0
        && Double.compare(attribute.score, score) == 0 && Objects
        .equals(name, attribute.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, minimumAssignableScore, maximumAssignableScore, score);
  }
}
