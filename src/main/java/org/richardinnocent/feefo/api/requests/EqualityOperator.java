package org.richardinnocent.feefo.api.requests;

public enum EqualityOperator {
  EQUALS("="),
  LESS_THAN("<"),
  LESS_THAN_OR_EQUAL_TO("<="),
  GREATER_THAN(">"),
  GREATER_THAN_OR_EQUAL_TO(">=");

  private final String symbol;

  EqualityOperator(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }
}
