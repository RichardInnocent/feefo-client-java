package org.richardinnocent.feefo.api.v10.reviews.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.Summary;

public class AllReviewsResponse {

  private Summary summary;
  private final List<Review> reviews = new ArrayList<>();

  public Summary getSummary() {
    return summary;
  }

  public void setSummary(Summary summary) {
    this.summary = summary;
  }

  public List<Review> getReviews() {
    return new ArrayList<>(reviews);
  }

  public void setReviews(List<Review> reviews) {
    this.reviews.clear();
    if (reviews != null) {
      this.reviews.addAll(reviews);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllReviewsResponse that = (AllReviewsResponse) o;
    return Objects.equals(summary, that.summary) && Objects
        .equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary, reviews);
  }

}
