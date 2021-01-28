package org.richardinnocent.feefo.api.v10.reviews.shared;

import java.util.List;
import java.util.Objects;

public class Tag {

  private String key;
  private List<String> values;
  private TagType type;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  public TagType getType() {
    return type;
  }

  public void setType(TagType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return Objects.equals(key, tag.key)
        && Objects.equals(values, tag.values)
        && type == tag.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, values, type);
  }
}
