package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class ProductThreadAttribute {

  private String name;

  @JsonProperty("old_rating")
  private Integer previousRating;

  @JsonProperty("new_rating")
  private Integer newRating;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPreviousRating() {
    return previousRating;
  }

  public void setPreviousRating(Integer previousRating) {
    this.previousRating = previousRating;
  }

  public Integer getNewRating() {
    return newRating;
  }

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
    ProductThreadAttribute that = (ProductThreadAttribute) o;
    return Objects.equals(name, that.name) && Objects
        .equals(previousRating, that.previousRating) && Objects
        .equals(newRating, that.newRating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, previousRating, newRating);
  }
}
