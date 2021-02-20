package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class TagFilterTest {

  @Test
  public void keyAndValuesCollectionConstructor_KeyIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new TagFilter(null, Collections.singletonList("value"))
    );
  }

  @Test
  public void keyAndValuesCollectionConstructor_KeyIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new TagFilter("", Collections.singletonList("value"))
    );
  }

  @Test
  public void keyAndValuesCollectionConstructor_ValuesIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new TagFilter("key", (Collection<String>) null)
    );
  }

  @Test
  public void keyAndValuesCollectionConstructor_ValuesIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new TagFilter("key", Collections.emptyList())
    );
  }

  @Test
  public void keyAndValuesCollectionConstructor_ValidParams_FieldsSet() {
    String key = "key";
    Collection<String> values = Arrays.asList("value1", "value2", "value3");
    TagFilter tagFilter = new TagFilter(key, values);
    assertEquals(key, tagFilter.getKey());
    assertEquals(values, tagFilter.getValues());
  }

  @Test
  public void keyAndValuesVarargsConstructor_KeyIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class, () -> new TagFilter(null, "value1", "value2", "value3")
    );
  }

  @Test
  public void keyAndValuesVarargsConstructor_KeyIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class, () -> new TagFilter("", "value1", "value2", "value3")
    );
  }

  @Test
  public void keyAndValuesVarargsConstructor_ValuesIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class, () -> new TagFilter("key", (String[]) null)
    );
  }

  @Test
  public void keyAndValuesVarargsConstructor_ValuesIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class, () -> new TagFilter("key", new String[0])
    );
  }

  @Test
  public void keyAndValuesVarargsConstructor_ValidParams_FieldsSet() {
    String key = "key";
    TagFilter tagFilter = new TagFilter(key, "value1", "value2", "value3");
    assertEquals(key, tagFilter.getKey());
    assertEquals(Arrays.asList("value1", "value2", "value3"), tagFilter.getValues());
  }

  @Test
  public void singleValueConstructor_KeyIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new TagFilter(null, "value"));
  }

  @Test
  public void singleValueConstructor_KeyIsEmpty_ExceptionThrown() {
    assertThrows(IllegalArgumentException.class, () -> new TagFilter("", "value"));
  }

  @Test
  public void singleValueConstructor_ValueIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new TagFilter("key", (String) null));
  }

  @Test
  public void singleValueConstructor_ValueIsEmpty_ExceptionThrown() {
    assertThrows(IllegalArgumentException.class, () -> new TagFilter("key", ""));
  }

  @Test
  public void singleValueConstructor_ValidParams_FieldsSet() {
    String key = "key";
    String value = "value";
    TagFilter tagFilter = new TagFilter(key, value);
    assertEquals(key, tagFilter.getKey());
    assertEquals(Collections.singletonList(value), tagFilter.getValues());
  }

  @Test
  public void toQueryValue_SingleValue_CreatesSimpleRepresentation() {
    String key = "key";
    String value = "value";
    TagFilter tagFilter = new TagFilter(key, value);
    assertEquals(key + ':' + value, tagFilter.toQueryValue());
  }

  @Test
  public void toQueryValue_MultipleValues_CreatesArrayLikeRepresentation() {
    String key = "key";
    List<String> values = Arrays.asList("value1", "value2", "value3");
    TagFilter tagFilter = new TagFilter(key, values);
    assertEquals(
        String.format("%s:[%s,%s,%s]", key, values.get(0), values.get(1), values.get(2)),
        tagFilter.toQueryValue()
    );
  }
}