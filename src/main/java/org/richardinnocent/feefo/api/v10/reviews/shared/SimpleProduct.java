package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class SimpleProduct {

  private String title;

  @JsonProperty("parent_sku")
  private String parentSku;

  private String sku;

  private String url;

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
    SimpleProduct product = (SimpleProduct) o;
    return Objects.equals(title, product.title)
        && Objects.equals(parentSku, product.parentSku)
        && Objects.equals(sku, product.sku)
        && Objects.equals(url, product.url)
        && Objects.equals(reviewsUrl, product.reviewsUrl)
        && Objects.equals(imageUrl, product.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, parentSku, sku, url, reviewsUrl, imageUrl);
  }

}
