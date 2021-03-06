package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnansweredFeedbackInclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", UnansweredFeedbackInclusion.INCLUDE.getQueryValue());
    assertEquals("exclude", UnansweredFeedbackInclusion.EXCLUDE.getQueryValue());
    assertEquals("exclude_negative", UnansweredFeedbackInclusion.EXCLUDE_NEGATIVE.getQueryValue());
  }

}