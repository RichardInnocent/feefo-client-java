package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaInclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", MediaInclusion.INCLUDE.getQueryKey());
    assertEquals("exclude", MediaInclusion.EXCLUDE.getQueryKey());
    assertEquals("only", MediaInclusion.MUST_HAVE_MEDIA.getQueryKey());
    assertEquals("video", MediaInclusion.MUST_HAVE_VIDEO.getQueryKey());
    assertEquals("photo", MediaInclusion.MUST_HAVE_PHOTO.getQueryKey());
  }

}