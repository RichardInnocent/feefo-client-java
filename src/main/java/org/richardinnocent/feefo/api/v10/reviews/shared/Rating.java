package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Rating {

  @JsonProperty("min")
  private int minimumAssignableRating;

  @JsonProperty("max")
  private int maximumAssignableRating;

  private int rating;

  public int getMinimumAssignableRating() {
    return minimumAssignableRating;
  }

  public void setMinimumAssignableRating(int minimumAssignableRating) {
    this.minimumAssignableRating = minimumAssignableRating;
  }

  public int getMaximumAssignableRating() {
    return maximumAssignableRating;
  }

  public void setMaximumAssignableRating(int maximumAssignableRating) {
    this.maximumAssignableRating = maximumAssignableRating;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rating rating1 = (Rating) o;
    return minimumAssignableRating == rating1.minimumAssignableRating
        && maximumAssignableRating == rating1.maximumAssignableRating && rating == rating1.rating;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minimumAssignableRating, maximumAssignableRating, rating);
  }
}
