package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaInclusionTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("include", MediaInclusion.INCLUDE.getQueryValue());
    assertEquals("exclude", MediaInclusion.EXCLUDE.getQueryValue());
    assertEquals("only", MediaInclusion.MUST_HAVE_MEDIA.getQueryValue());
    assertEquals("video", MediaInclusion.MUST_HAVE_VIDEO.getQueryValue());
    assertEquals("photo", MediaInclusion.MUST_HAVE_PHOTO.getQueryValue());
  }

}