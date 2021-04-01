package org.richardinnocent.feefo.api.v10.reviews.reviews.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.reviews.service.dto.SimpleReview;
import org.richardinnocent.feefo.api.v10.reviews.reviews.shared.ReviewsResponse;

/**
 * A response for a {@link SimpleServiceReviewsRequest}.
 */
public class SimpleServiceReviewsResponse extends ReviewsResponse {

  private final List<SimpleReview> reviews = new ArrayList<>();

  /**
   * Gets the reviews shown on this page of results.
   * @return The reviews shown on this page of results.
   */
  public List<SimpleReview> getReviews() {
    return new ArrayList<>(reviews);
  }

  /**
   * Sets the reviews shown on this page of results.
   * @param reviews The reviews shown on this page of results.
   */
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
    if (!super.equals(o)) {
      return false;
    }
    SimpleServiceReviewsResponse that = (SimpleServiceReviewsResponse) o;
    return Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), reviews);
  }
}
