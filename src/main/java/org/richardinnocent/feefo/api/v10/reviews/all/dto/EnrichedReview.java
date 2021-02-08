package org.richardinnocent.feefo.api.v10.reviews.all.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.NetPromoterScore;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Merchant;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedProductFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.EnrichedServiceFeedback;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.SocialNetworks;
import org.richardinnocent.feefo.api.v10.reviews.shared.dto.Tag;

public class EnrichedReview {

  private Merchant merchant;

  @JsonProperty("last_updated_date")
  private LocalDateTime lastUpdatedDate;

  @JsonProperty("products_purchased")
  private final List<String> productsPurchased = new ArrayList<>();

  private final List<Tag> tags = new ArrayList<>();

  private String url;

  @JsonProperty("social")
  private SocialNetworks socialNetworks;

  private EnrichedCustomer customer;

  @JsonProperty("service")
  private EnrichedServiceFeedback serviceFeedback;

  @JsonProperty("products")
  private final List<EnrichedProductFeedback> productFeedback = new ArrayList<>();

  @JsonProperty("nps")
  private NetPromoterScore netPromoterScore;

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

  public List<Tag> getTags() {
    return new ArrayList<>(tags);
  }

  public void setTags(List<Tag> tags) {
    this.tags.clear();
    if (tags != null) {
      this.tags.addAll(tags);
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

  public EnrichedCustomer getCustomer() {
    return customer;
  }

  public void setCustomer(EnrichedCustomer customer) {
    this.customer = customer;
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

  public NetPromoterScore getNetPromoterScore() {
    return netPromoterScore;
  }

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
    EnrichedReview review = (EnrichedReview) o;
    return Objects.equals(merchant, review.merchant)
        && Objects.equals(lastUpdatedDate, review.lastUpdatedDate)
        && Objects.equals(productsPurchased, review.productsPurchased)
        && Objects.equals(tags, review.tags)
        && Objects.equals(url, review.url)
        && Objects.equals(socialNetworks, review.socialNetworks)
        && Objects.equals(customer, review.customer)
        && Objects.equals(serviceFeedback, review.serviceFeedback)
        && Objects.equals(productFeedback, review.productFeedback)
        && Objects.equals(netPromoterScore, review.netPromoterScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        merchant, lastUpdatedDate, productsPurchased, tags, url, socialNetworks, customer,
        serviceFeedback, productFeedback, netPromoterScore
    );
  }

}
