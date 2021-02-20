package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmptyProductCommentInclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", EmptyProductCommentInclusion.INCLUDE.getQueryKey());
    assertEquals("default", EmptyProductCommentInclusion.INJECT_DEFAULT_COMMENT.getQueryKey());
    assertEquals("exclude", EmptyProductCommentInclusion.EXCLUDE.getQueryKey());
  }

}