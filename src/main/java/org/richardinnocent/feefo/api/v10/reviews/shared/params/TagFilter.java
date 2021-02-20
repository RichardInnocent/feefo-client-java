package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class TagFilter {

  private final String key;
  private final Collection<String> values;

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

  public TagFilter(String key, String... values)
      throws NullPointerException, IllegalArgumentException {
    this(key, Arrays.asList(values));
  }

  public TagFilter(String key, String value) {
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

  public String getKey() {
    return key;
  }

  public Collection<String> getValues() {
    return new ArrayList<>(values);
  }

  public String toQueryValue() {
    return values.size() == 1 ?
        key + ':' + values.iterator().next() :
        String.format("%s:[%s]", key, String.join(",", values));
  }

}
