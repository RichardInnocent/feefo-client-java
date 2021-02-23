package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Contains detail of a tag filter that can be used to include or exclude feedback based on its
 * tags.
 */
public class TagFilter {

  private final String key;
  private final Collection<String> values;

  /**
   * Creates a new tag filter. This can be used to include or exclude feedback based on its tags.
   * @param key The tag key.
   * @param values The values associated with the tag.
   * @throws NullPointerException Thrown if {@code key == null || values == null}.
   * @throws IllegalArgumentException Thrown if {@code key.isEmpty() || values.isEmpty()}.
   */
  public TagFilter(String key, Collection<String> values)
      throws NullPointerException, IllegalArgumentException {
    this.key = ensureNotEmpty(key, "Key");
    Objects.requireNonNull(
        values, "Values collection is null - you must specify at least one tag value"
    );
    if (values.isEmpty()) {
      throw new IllegalArgumentException(
          "Values collection is empty - you must specify at least one tag value"
      );
    }
    this.values = new ArrayList<>(values);
  }

  /**
   * Creates a new tag filter. This can be used to include or exclude feedback based on its tags.
   * @param key The tag key.
   * @param values The values associated with the tag.
   * @throws NullPointerException Thrown if {@code key == null || values == null}.
   * @throws IllegalArgumentException Thrown if {@code key.isEmpty() || values.length == 0}.
   */
  public TagFilter(String key, String... values)
      throws NullPointerException, IllegalArgumentException {
    this(key, Arrays.asList(values));
  }

  /**
   * Creates a new tag filter. This can be used to include or exclude feedback based on its tags.
   * @param key The tag key.
   * @param value The tag value.
   * @throws NullPointerException Thrown if {@code key == null || value == null}.
   * @throws IllegalArgumentException Thrown if {@code key.isEmpty() || value.isEmpty()}.
   */
  public TagFilter(String key, String value) throws NullPointerException, IllegalArgumentException {
    this.key = ensureNotEmpty(key, "Key");
    this.values = Collections.singletonList(ensureNotEmpty(value, "Value"));
  }

  private String ensureNotEmpty(String value, String name)
      throws NullPointerException, IllegalArgumentException {
    if (value == null) {
      throw new NullPointerException(name + " is null");
    }
    if (value.isEmpty()) {
      throw new IllegalArgumentException(name + " is empty");
    }
    return value;
  }

  /**
   * Gets the tag key.
   * @return The tag key.
   */
  public String getKey() {
    return key;
  }

  /**
   * Gets the tag values.
   * @return The tag values.
   */
  public Collection<String> getValues() {
    return new ArrayList<>(values);
  }

  /**
   * Gets the value as it should appear in API requests.
   * @return The value as it should appear in API requests.
   */
  public String toQueryValue() {
    return values.size() == 1 ?
        key + ':' + values.iterator().next() :
        String.format("%s:[%s]", key, String.join(",", values));
  }

}
