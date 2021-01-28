package org.richardinnocent.feefo.api.v10.reviews.shared;

import java.util.Objects;

public class Feature {

  private String text;
  private Double score;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Double getScore() {
    return score;
  }

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
