package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductThreadEntry extends ThreadEntry {

  private final List<ProductThreadAttribute> attributes = new ArrayList<>();

  public List<ProductThreadAttribute> getAttributes() {
    return new ArrayList<>(attributes);
  }

  public void setAttributes(List<ProductThreadAttribute> attributes) {
    this.attributes.clear();
    if (attributes != null) {
      this.attributes.addAll(attributes);
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
    return Objects.equals(attributes, that.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), attributes);
  }
}
