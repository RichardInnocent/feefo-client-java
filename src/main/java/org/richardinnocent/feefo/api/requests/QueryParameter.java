package org.richardinnocent.feefo.api.requests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class QueryParameter {

  private final String key;
  private final EqualityOperator equalityOperator;
  private final String value;

  public QueryParameter(String key, String value) throws NullPointerException {
    this(key, EqualityOperator.EQUALS, value);
  }

  public QueryParameter(String key, EqualityOperator equalityOperator, String value)
      throws NullPointerException {
    this.key = Objects.requireNonNull(key, "Key is null");
    this.equalityOperator = Objects.requireNonNull(equalityOperator, "Equality operator is null");
    this.value = Objects.requireNonNull(value, "Value is null");
  }

  public String getKey() {
    return key;
  }

  public EqualityOperator getEqualityOperator() {
    return equalityOperator;
  }

  public String getValue() {
    return value;
  }

  public String toQueryStringForm() throws UnsupportedEncodingException {
    return URLEncoder.encode(key, StandardCharsets.UTF_8.toString())
        + equalityOperator.getSymbol()
        + URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
  }

  @Override
  public String toString() {
    try {
      return toQueryStringForm();
    } catch (UnsupportedEncodingException e) {
      return key + equalityOperator.getSymbol() + value;
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
    QueryParameter that = (QueryParameter) o;
    return Objects.equals(key, that.key) && equalityOperator == that.equalityOperator
        && Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, equalityOperator, value);
  }
}
