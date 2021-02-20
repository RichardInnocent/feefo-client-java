package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", Inclusion.INCLUDE.getQueryKey());
    assertEquals("exclude", Inclusion.EXCLUDE.getQueryKey());
  }

}