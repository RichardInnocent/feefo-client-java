package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains product feedback information. This can contain personally identifiable or
 * business-sensitive information, so is only returned from authorised requests.
 */
public class SimpleProductFeedback extends SimpleFeedback {

  private SimpleProduct product;

  @JsonProperty("thread")
  private final List<ProductThreadEntry> auditThread = new ArrayList<>();

  /**
   * Gets details of the product that was reviewed.
   * @return Details of the product that was reviewed.
   */
  public SimpleProduct getProduct() {
    return product;
  }

  /**
   * Sets the details of the product that was reviewed.
   * @param product The details of the product that was reviewed.
   */
  public void setProduct(SimpleProduct product) {
    this.product = product;
  }

  /**
   * Gets an audit history for the feedback, including changes to the review and the conversation
   * between the consumer and merchant.
   * @return The audit history for the feedback.
   */
  public List<ProductThreadEntry> getAuditThread() {
    return new ArrayList<>(auditThread);
  }

  /**
   * Sets the audit history for the feedback, including changes to the review and the conversation
   * between the consumer and merchant.
   * @param auditThread The audit history for the feedback.
   */
  public void setAuditThread(List<ProductThreadEntry> auditThread) {
    this.auditThread.clear();
    if (auditThread != null) {
      this.auditThread.addAll(auditThread);
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
    if (!super.equals(o)) {
      return false;
    }
    SimpleProductFeedback that = (SimpleProductFeedback) o;
    return Objects.equals(product, that.product)
        && Objects.equals(auditThread, that.auditThread);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), product, auditThread);
  }

}
