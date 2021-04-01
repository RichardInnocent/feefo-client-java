package org.richardinnocent.feefo.api.v10.reviews.reviews.all;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.reviews.all.dto.SimpleReview;
import org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto.Summary;

public class SimpleAllReviewsResponse {

  private Summary summary;
  private final List<SimpleReview> reviews = new ArrayList<>();

  public Summary getSummary() {
    return summary;
  }

  public void setSummary(Summary summary) {
    this.summary = summary;
  }

  public List<SimpleReview> getReviews() {
    return new ArrayList<>(reviews);
  }

  public void setReviews(List<SimpleReview> reviews) {
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
    SimpleAllReviewsResponse that = (SimpleAllReviewsResponse) o;
    return Objects.equals(summary, that.summary) && Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary, reviews);
  }

}
