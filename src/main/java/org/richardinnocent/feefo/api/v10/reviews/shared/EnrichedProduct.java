package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnrichedProduct {

  private String title;

  @JsonProperty("parent_sku")
  private String parentSku;

  private String sku;

  private String url;

  private final List<Tag> tags = new ArrayList<>();

  @JsonProperty("reviews_url")
  private String reviewsUrl;

  @JsonProperty("image_url")
  private String imageUrl;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getReviewsUrl() {
    return reviewsUrl;
  }

  public void setReviewsUrl(String reviewsUrl) {
    this.reviewsUrl = reviewsUrl;
  }

  public String getParentSku() {
    return parentSku;
  }

  public void setParentSku(String parentSku) {
    this.parentSku = parentSku;
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrichedProduct product = (EnrichedProduct) o;
    return Objects.equals(title, product.title)
        && Objects.equals(parentSku, product.parentSku)
        && Objects.equals(sku, product.sku)
        && Objects.equals(url, product.url)
        && Objects.equals(tags, product.tags)
        && Objects.equals(reviewsUrl, product.reviewsUrl)
        && Objects.equals(imageUrl, product.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, parentSku, sku, url, tags, reviewsUrl, imageUrl);
  }
}
