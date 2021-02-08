package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Attribute {

  private String name;

  @JsonProperty("min")
  private double minimumAssignableRating;

  @JsonProperty("max")
  private double maximumAssignableRating;

  private double rating;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMinimumAssignableRating() {
    return minimumAssignableRating;
  }

  public void setMinimumAssignableRating(double minimumAssignableRating) {
    this.minimumAssignableRating = minimumAssignableRating;
  }

  public double getMaximumAssignableRating() {
    return maximumAssignableRating;
  }

  public void setMaximumAssignableRating(double maximumAssignableRating) {
    this.maximumAssignableRating = maximumAssignableRating;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
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
    Attribute attribute = (Attribute) o;
    return Double.compare(attribute.minimumAssignableRating, minimumAssignableRating) == 0
        && Double.compare(attribute.maximumAssignableRating, maximumAssignableRating) == 0
        && Double.compare(attribute.rating, rating) == 0 && Objects
        .equals(name, attribute.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, minimumAssignableRating, maximumAssignableRating, rating);
  }
}
