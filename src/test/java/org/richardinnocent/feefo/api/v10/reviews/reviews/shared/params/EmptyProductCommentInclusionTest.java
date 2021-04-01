package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmptyProductCommentInclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", EmptyProductCommentInclusion.INCLUDE.getQueryValue());
    assertEquals("default", EmptyProductCommentInclusion.INJECT_DEFAULT_COMMENT.getQueryValue());
    assertEquals("exclude", EmptyProductCommentInclusion.EXCLUDE.getQueryValue());
  }

}