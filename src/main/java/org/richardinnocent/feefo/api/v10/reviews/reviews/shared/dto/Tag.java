package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Tags are identifiers that can be associated with a sale, feedback or product that allow merchants
 * to organise their information. For example, a furniture merchant may choose to add a tag as
 * follows to a product to compare the performance of their tables:
 * <pre><code>"category": ["table", "indoor"]</code></pre>
 */
public class Tag {

  private String key;
  private List<String> values = new ArrayList<>();
  private TagType type;

  /**
   * Gets the tag key.
   * @return The tag key.
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets the tag key.
   * @param key The tag key.
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Gets the values assigned to this tag.
   * @return The values assigned to this tag.
   */
  public List<String> getValues() {
    return new ArrayList<>(values);
  }

  /**
   * Sets the values assigned to this tag.
   * @param values The values assigned to this tag.
   */
  public void setValues(List<String> values) {
    this.values.clear();
    if (values != null) {
      this.values.addAll(values);
    }
  }

  /**
   * Gets the tag type.
   * @return The tag type.
   */
  public TagType getType() {
    return type;
  }

  /**
   * Sets the tag type.
   * @param type The tag type.
   */
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
