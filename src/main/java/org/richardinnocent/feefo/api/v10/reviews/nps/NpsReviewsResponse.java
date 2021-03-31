package org.richardinnocent.feefo.api.v10.reviews.nps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.nps.dto.NpsReview;
import org.richardinnocent.feefo.api.v10.reviews.shared.ReviewsResponse;

public class NpsReviewsResponse extends ReviewsResponse {

  private final List<NpsReview> reviews = new ArrayList<>();

  /**
   * Gets the reviews shown on this page of results.
   * @return The reviews shown on this page of results.
   */
  public List<NpsReview> getReviews() {
    return new ArrayList<>(reviews);
  }

  /**
   * Sets the reviews shown on this page of results.
   * @param reviews The reviews shown on this page of results.
   */
  public void setReviews(List<NpsReview> reviews) {
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
    if (!(o instanceof NpsReviewsResponse)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    NpsReviewsResponse that = (NpsReviewsResponse) o;
    return Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), reviews);
  }
}
