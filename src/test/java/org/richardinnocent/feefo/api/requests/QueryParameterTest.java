package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

class QueryParameterTest {

  @Test
  public void equalsAndHashCode_Always_Valid() {
    EqualsVerifier.forClass(QueryParameter.class).suppress(Warning.STRICT_INHERITANCE).verify();
  }

  @Test
  public void keyValueConstructor_KeyIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new QueryParameter(null, "test_value"));
  }

  @Test
  public void keyValueConstructor_ValueIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new QueryParameter("test_key", null));
  }

  @Test
  public void keyValueConstructor_Always_SetsKeyAndValueAsExpectedWithOperatorAsEquals() {
    String key = "test_key";
    String value = "test_value";
    QueryParameter parameter = new QueryParameter(key, value);
    assertEquals(key, parameter.getKey());
    assertEquals(EqualityOperator.EQUALS, parameter.getEqualityOperator());
    assertEquals(value, parameter.getValue());
  }

  @Test
  public void keyOperatorAndValueConstructor_KeyIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new QueryParameter(null, EqualityOperator.EQUALS, "test_value")
    );
  }

  @Test
  public void keyOperatorAndValueConstructor_EqualityOperatorIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new QueryParameter("test_key", null, "test_value")
    );
  }

  @Test
  public void keyOperatorAndValueConstructor_ValueIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> new QueryParameter("test_key", EqualityOperator.EQUALS, null)
    );
  }

  @Test
  public void keyOperatorAndValueConstructor_Always_SetsKeyOperatorAndValueAsExpected() {
    String key = "test_key";
    EqualityOperator equalityOperator = EqualityOperator.GREATER_THAN;
    String value = "test_value";
    QueryParameter parameter = new QueryParameter(key, equalityOperator, value);
    assertEquals(key, parameter.getKey());
    assertEquals(equalityOperator, parameter.getEqualityOperator());
    assertEquals(value, parameter.getValue());
  }

  @Test
  public void toQueryStringForm_BasicKeyAndValue_ReturnsKeyThenOperatorThenValue()
      throws UnsupportedEncodingException {
    String key = "test_key";
    EqualityOperator greaterThan = EqualityOperator.GREATER_THAN;
    String value = "test_value";
    assertEquals(
        key + greaterThan.getSymbol() + value,
        new QueryParameter(key, greaterThan, value).toQueryStringForm()
    );
  }

  @Test
  public void toQueryStringForm_KeyAndValueWithSpecialCharacters_ReturnsKeyAndValueEncoded()
      throws UnsupportedEncodingException {
    String key = "test?key";
    EqualityOperator equals = EqualityOperator.EQUALS;
    String value = "test=val ue";
    assertEquals(
        "test%3Fkey" + equals.getSymbol() + "test%3Dval+ue",
        new QueryParameter(key, equals, value).toQueryStringForm()
    );
  }

}