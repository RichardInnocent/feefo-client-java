package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Represents a re-rate of a product attribute.
 */
public class ReRatedProductAttribute {

  private String name;

  @JsonProperty("old_rating")
  private Integer previousRating;

  @JsonProperty("new_rating")
  private Integer newRating;

  /**
   * Gets the name of the attribute that has been re-rated.
   * @return The name of the attribute that has been re-rated.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the attribute that has been re-rated.
   * @param name The name of the attribute that has been re-rated.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The previous rating for this attribute. This should be between 1 and 5.
   * @return The previous rating for this attribute.
   */
  public Integer getPreviousRating() {
    return previousRating;
  }

  /**
   * Sets the previous rating for this attribute.
   * @param previousRating The previous rating for this attribute. This should be between 1 and 5.
   */
  public void setPreviousRating(Integer previousRating) {
    this.previousRating = previousRating;
  }

  /**
   * Gets the new rating for this attribute. This should be between 1 and 5.
   * @return The new rating for this attribute.
   */
  public Integer getNewRating() {
    return newRating;
  }

  /**
   * Sets the new rating for this attribute. This should be between 1 and 5.
   * @param newRating The new rating for this attribute.
   */
  public void setNewRating(Integer newRating) {
    this.newRating = newRating;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReRatedProductAttribute that = (ReRatedProductAttribute) o;
    return Objects.equals(name, that.name) && Objects
        .equals(previousRating, that.previousRating) && Objects
        .equals(newRating, that.newRating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, previousRating, newRating);
  }
}
