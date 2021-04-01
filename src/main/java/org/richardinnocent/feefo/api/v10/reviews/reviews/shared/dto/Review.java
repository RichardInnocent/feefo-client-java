package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains information about a review.
 */
public abstract class Review {

  private Merchant merchant;

  @JsonProperty("last_updated_date")
  private OffsetDateTime lastUpdatedDate;

  @JsonProperty("products_purchased")
  private final List<String> productsPurchased = new ArrayList<>();

  private final List<Tag> tags = new ArrayList<>();

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
   * Gets the tags associated with this review.
   * @return The tags associated with this review.
   */
  public List<Tag> getTags() {
    return new ArrayList<>(tags);
  }

  /**
   * Sets the tags associated with this review.
   * @param tags The tags associated with this review.
   */
  public void setTags(List<Tag> tags) {
    this.tags.clear();
    if (tags != null) {
      this.tags.addAll(tags);
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
    Review review = (Review) o;
    return Objects.equals(merchant, review.merchant) && Objects
        .equals(lastUpdatedDate, review.lastUpdatedDate) && Objects
        .equals(productsPurchased, review.productsPurchased) && Objects
        .equals(tags, review.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchant, lastUpdatedDate, productsPurchased, tags);
  }
}
