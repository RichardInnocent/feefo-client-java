package org.richardinnocent.feefo.api.v10.reviews.all.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Merchant;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SimpleProductFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SimpleServiceFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SocialNetworks;

/**
 * Contains details of a review.
 */
public class SimpleReview {

  private Merchant merchant;

  @JsonProperty("last_updated_date")
  private OffsetDateTime lastUpdatedDate;

  @JsonProperty("products_purchased")
  private final List<String> productsPurchased = new ArrayList<>();

  private String url;

  @JsonProperty("social")
  private SocialNetworks socialNetworks;

  private SimpleCustomer customer;

  @JsonProperty("service")
  private SimpleServiceFeedback serviceFeedback;

  @JsonProperty("products")
  private final List<SimpleProductFeedback> productFeedback = new ArrayList<>();

  /**
   * Gets the merchant of the sale.
   * @return The merchant of the sale.
   */
  public Merchant getMerchant() {
    return merchant;
  }

  /**
   * Sets the merchant of the sale.
   * @param merchant The merchant of the sale.
   */
  public void setMerchant(Merchant merchant) {
    this.merchant = merchant;
  }

  /**
   * Gets the time that the review was last updated.
   * @return The time that the review was last updated.
   */
  public OffsetDateTime getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  /**
   * Sets the time that the review was last updated.
   * @param lastUpdatedDate The time that the review was last updated.
   */
  public void setLastUpdatedDate(OffsetDateTime lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  /**
   * Gets the names of the products that were purchased in the sale.
   * @return The names of the products that were purchased in the sale.
   */
  public List<String> getProductsPurchased() {
    return new ArrayList<>(productsPurchased);
  }

  /**
   * Sets the names of the products that were purchased in the sale.
   * @param productsPurchased The names of the products that were purchased in the sale.
   */
  public void setProductsPurchased(List<String> productsPurchased) {
    this.productsPurchased.clear();
    if (productsPurchased != null) {
      this.productsPurchased.addAll(productsPurchased);
    }
  }

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
  public SimpleCustomer getCustomer() {
    return customer;
  }

  /**
   * Sets the details of the customer that left the review.
   * @param customer The details of the customer that left the review.
   */
  public void setCustomer(SimpleCustomer customer) {
    this.customer = customer;
  }

  /**
   * Gets the feedback for the service.
   * @return The feedback for the service.
   */
  public SimpleServiceFeedback getServiceFeedback() {
    return serviceFeedback;
  }

  /**
   * Sets the feedback for the service.
   * @param serviceFeedback The feedback for the service.
   */
  public void setServiceFeedback(SimpleServiceFeedback serviceFeedback) {
    this.serviceFeedback = serviceFeedback;
  }

  /**
   * Gets the feedback for the products purchased in this sale.
   * @return The feedback for the products purchased in this sale.
   */
  public List<SimpleProductFeedback> getProductFeedback() {
    return new ArrayList<>(productFeedback);
  }

  /**
   * Sets the product feedback for the products purchased in this sale.
   * @param productFeedback The product feedback for the products purchased in this sale.
   */
  public void setProductFeedback(List<SimpleProductFeedback> productFeedback) {
    this.productFeedback.clear();
    if (productFeedback != null) {
      this.productFeedback.addAll(productFeedback);
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
    SimpleReview review = (SimpleReview) o;
    return Objects.equals(merchant, review.merchant)
        && Objects.equals(lastUpdatedDate, review.lastUpdatedDate)
        && Objects.equals(productsPurchased, review.productsPurchased)
        && Objects.equals(url, review.url)
        && Objects.equals(socialNetworks, review.socialNetworks)
        && Objects.equals(customer, review.customer)
        && Objects.equals(serviceFeedback, review.serviceFeedback)
        && Objects.equals(productFeedback, review.productFeedback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        merchant, lastUpdatedDate, productsPurchased, url, socialNetworks, customer,
        serviceFeedback, productFeedback
    );
  }

}
