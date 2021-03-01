package org.richardinnocent.feefo.api.v10.reviews.shared;

import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Summary;

/**
 * Contains details from a reviews request.
 */
public abstract class ReviewsResponse {

  private Summary summary;

  /**
   * Gets the metadata summary, which includes information such as pagination.
   * @return The metadata summary.
   */
  public Summary getSummary() {
    return summary;
  }

  /**
   * Sets the metadata summary, which includes information such as pagination.
   * @param summary The metadata summary.
   */
  public void setSummary(Summary summary) {
    this.summary = summary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReviewsResponse that = (ReviewsResponse) o;
    return Objects.equals(summary, that.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary);
  }
}
