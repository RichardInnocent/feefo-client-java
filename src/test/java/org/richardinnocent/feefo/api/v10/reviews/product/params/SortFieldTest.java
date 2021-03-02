package org.richardinnocent.feefo.api.v10.reviews.product.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortFieldTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("created_date", SortField.FEEDBACK_CREATION_TIME.getQueryKey());
    assertEquals("updated_date", SortField.FEEDBACK_UPDATED_TIME.getQueryKey());
    assertEquals("helpful", SortField.HELPFUL_VOTES.getQueryKey());
  }

}