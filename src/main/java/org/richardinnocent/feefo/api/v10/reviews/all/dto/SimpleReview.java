package org.richardinnocent.feefo.api.v10.reviews.all.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Merchant;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedProductFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedServiceFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SocialNetworks;

public class SimpleReview {

  private Merchant merchant;

  @JsonProperty("last_updated_date")
  private LocalDateTime lastUpdatedDate;

  @JsonProperty("products_purchased")
  private final List<String> productsPurchased = new ArrayList<>();

  private String url;

  @JsonProperty("social")
  private SocialNetworks socialNetworks;

  private SimpleCustomer customer;

  @JsonProperty("service")
  private EnrichedServiceFeedback serviceFeedback;

  @JsonProperty("products")
  private final List<EnrichedProductFeedback> productFeedback = new ArrayList<>();

  public Merchant getMerchant() {
    return merchant;
  }

  public void setMerchant(Merchant merchant) {
    this.merchant = merchant;
  }

  public LocalDateTime getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

  public List<String> getProductsPurchased() {
    return new ArrayList<>(productsPurchased);
  }

  public void setProductsPurchased(List<String> productsPurchased) {
    this.productsPurchased.clear();
    if (productsPurchased != null) {
      this.productsPurchased.addAll(productsPurchased);
    }
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public SocialNetworks getSocialNetworks() {
    return socialNetworks;
  }

  public void setSocialNetworks(SocialNetworks socialNetworks) {
    this.socialNetworks = socialNetworks;
  }

  public EnrichedServiceFeedback getServiceFeedback() {
    return serviceFeedback;
  }

  public void setServiceFeedback(EnrichedServiceFeedback serviceFeedback) {
    this.serviceFeedback = serviceFeedback;
  }

  public List<EnrichedProductFeedback> getProductFeedback() {
    return new ArrayList<>(productFeedback);
  }

  public void setProductFeedback(List<EnrichedProductFeedback> productFeedback) {
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
