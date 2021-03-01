package org.richardinnocent.feefo.api.v10.reviews.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedCustomer;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedServiceFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Review;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SocialNetworks;

/**
 * Contains details of a review.
 */
public class EnrichedReview extends Review {

  private String url;

  @JsonProperty("social")
  private SocialNetworks socialNetworks;

  private EnrichedCustomer customer;

  @JsonProperty("service")
  private EnrichedServiceFeedback serviceFeedback;

  /**
   * Gets the URL of the review on Feefo's website.
   * @return The URL of the review on Feefo's website.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the URL of the review on Feefo's website.
   * @param url The URL of the review on Feefo's website.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Gets the social network share links for the review.
   * @return The social network share links for the review.
   */
  public SocialNetworks getSocialNetworks() {
    return socialNetworks;
  }

  /**
   * Sets the social network share links for the review.
   * @param socialNetworks The social network share links for the review.
   */
  public void setSocialNetworks(SocialNetworks socialNetworks) {
    this.socialNetworks = socialNetworks;
  }

  /**
   * Gets the details of the customer that left the review.
   * @return The details of the customer that left the review.
   */
  public EnrichedCustomer getCustomer() {
    return customer;
  }

  /**
   * Sets the details of the customer that left the review.
   * @param customer The details of the customer that left the review.
   */
  public void setCustomer(EnrichedCustomer customer) {
    this.customer = customer;
  }

  /**
   * Gets the feedback for the service.
   * @return The feedback for the service.
   */
  public EnrichedServiceFeedback getServiceFeedback() {
    return serviceFeedback;
  }

  /**
   * Sets the feedback for the service.
   * @param serviceFeedback The feedback for the service.
   */
  public void setServiceFeedback(EnrichedServiceFeedback serviceFeedback) {
    this.serviceFeedback = serviceFeedback;
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
    EnrichedReview that = (EnrichedReview) o;
    return Objects.equals(url, that.url) && Objects
        .equals(socialNetworks, that.socialNetworks) && Objects
        .equals(customer, that.customer) && Objects
        .equals(serviceFeedback, that.serviceFeedback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), url, socialNetworks, customer, serviceFeedback);
  }
}
