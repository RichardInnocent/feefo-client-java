package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductFeedback extends Feedback {

  private Product product;

  @JsonProperty("thread")
  private final List<ProductThreadEntry> commentThread = new ArrayList<>();

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public List<ProductThreadEntry> getCommentThread() {
    return new ArrayList<>(commentThread);
  }

  public void setCommentThread(List<ProductThreadEntry> commentThread) {
    this.commentThread.clear();
    if (commentThread != null) {
      this.commentThread.addAll(commentThread);
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
    ProductFeedback that = (ProductFeedback) o;
    return Objects.equals(product, that.product)
        && Objects.equals(commentThread, that.commentThread);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), product, commentThread);
  }

}
