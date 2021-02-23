package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains an audit history for some product feedback, including changes to the review and the
 * conversation between the consumer and merchant.
 */
public class ProductThreadEntry extends ThreadEntry {

  @JsonProperty("attributes")
  private final List<ReRatedProductAttribute> reRatedProductAttributes = new ArrayList<>();

  public List<ReRatedProductAttribute> getReRatedProductAttributes() {
    return new ArrayList<>(reRatedProductAttributes);
  }

  public void setReRatedProductAttributes(List<ReRatedProductAttribute> reRatedProductAttributes) {
    this.reRatedProductAttributes.clear();
    if (reRatedProductAttributes != null) {
      this.reRatedProductAttributes.addAll(reRatedProductAttributes);
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
    ProductThreadEntry that = (ProductThreadEntry) o;
    return Objects.equals(reRatedProductAttributes, that.reRatedProductAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), reRatedProductAttributes);
  }
}
