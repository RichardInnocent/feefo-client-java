package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", Inclusion.INCLUDE.getQueryValue());
    assertEquals("exclude", Inclusion.EXCLUDE.getQueryValue());
  }

}