package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Contains details on a product. This will not contain personally identifiable or
 * business-sensitive information, so can be returned from unauthenticated requests.
 */
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

  /**
   * Gets the title of the product.
   * @return The title of the product.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the product.
   * @param title The title of the product.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the SKU assigned to the product.
   * @return The SKU assigned to the product.
   */
  public String getSku() {
    return sku;
  }

  /**
   * Sets the SKU assigned to the product.
   * @param sku The SKU assigned to the product.
   */
  public void setSku(String sku) {
    this.sku = sku;
  }

  /**
   * Gets the URL of the product on the merchant’s website. In order of preference the following URL
   * will be returned:
   * <ul>
   *   <li>Product URL specified in an uploaded catalogue.</li>
   *   <li>Product URL specified in the sales file.</li>
   *   <li>URL specified as the product forwarding URL within merchant settings.</li>
   *   <li>URL specified as the website forwarding URL within merchant settings.</li>
   * </ul>
   * @return The URL of the product on the merchant's website.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the URL of the product on the merchant's website.
   * @param url The URL of the product on the merchant's website.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Gets the URL for all reviews for the product on Feefo’s website in the form:<br />
   * {@code http://www.feefo.com/locale/reviews/merchant-identifier/products/product-name?sku=product-sku}<br />
   * where a parent product SKU has been provided the link will pass through the parent SKU.
   * @return The URL for all reviews for the product on Feefo's website.
   */
  public String getReviewsUrl() {
    return reviewsUrl;
  }

  /**
   * Sets the URL for all reviews for the product on Feefo's website. The URL should be in the form:
   * <br />
   * {@code http://www.feefo.com/locale/reviews/merchant-identifier/products/product-name?sku=product-sku}<br />
   * where a parent product SKU has been provided the link will pass through the parent SKU.
   * @param reviewsUrl The URL for all reviews for the product on Feefo's website.
   */
  public void setReviewsUrl(String reviewsUrl) {
    this.reviewsUrl = reviewsUrl;
  }

  /**
   * The parent SKU assigned to the product.
   * @return The parent SKU assigned to the product.
   */
  public String getParentSku() {
    return parentSku;
  }

  /**
   * Sets the parent SKU assigned to the product.
   * @param parentSku The parent SKU assigned to the product.
   */
  public void setParentSku(String parentSku) {
    this.parentSku = parentSku;
  }

  /**
   * Gets the URL of the product image stored by Feefo, as uploaded via the product catalogue.
   * @return The URL of the product image stored by Feefo.
   */
  public String getImageUrl() {
    return imageUrl;
  }

  /**
   * Sets the URL of the product image stored by Feefo.
   * @param imageUrl The URL of the product image stored by Feefo.
   */
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
