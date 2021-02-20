package org.richardinnocent.feefo.api.requests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualityOperatorTest {

  @Test
  public void getSymbol_All_AsExpected() {
    assertEquals("=", EqualityOperator.EQUALS.getSymbol());
    assertEquals(">", EqualityOperator.GREATER_THAN.getSymbol());
    assertEquals(">=", EqualityOperator.GREATER_THAN_OR_EQUAL_TO.getSymbol());
    assertEquals("<", EqualityOperator.LESS_THAN.getSymbol());
    assertEquals("<=", EqualityOperator.LESS_THAN_OR_EQUAL_TO.getSymbol());
  }

}