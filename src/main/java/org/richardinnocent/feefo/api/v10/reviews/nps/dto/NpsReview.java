package org.richardinnocent.feefo.api.v10.reviews.nps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.NetPromoterScore;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Review;

/**
 * Contains details on a review with a net promoter score (NPS).
 */
public class NpsReview extends Review {

  private NpsCustomer customer;

  @JsonProperty("nps")
  private NetPromoterScore netPromoterScore;

  /**
   * Gets the details of the customer that left the review.
   * @return The details of the customer that left the review.
   */
  public NpsCustomer getCustomer() {
    return customer;
  }

  /**
   * Sets the details of the customer that left the review.
   * @param customer The details of the customer that left the review.
   */
  public void setCustomer(NpsCustomer customer) {
    this.customer = customer;
  }

  /**
   * Gets the net promoter score (NPS).
   * @return The net promoter score.
   */
  public NetPromoterScore getNetPromoterScore() {
    return netPromoterScore;
  }

  /**
   * Sets the net promoter score (NPS).
   * @param netPromoterScore The net promoter score.
   */
  public void setNetPromoterScore(NetPromoterScore netPromoterScore) {
    this.netPromoterScore = netPromoterScore;
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
    NpsReview npsReview = (NpsReview) o;
    return Objects.equals(customer, npsReview.customer) && Objects
        .equals(netPromoterScore, npsReview.netPromoterScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), customer, netPromoterScore);
  }
}
