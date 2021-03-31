package org.richardinnocent.feefo.api.v10.reviews.nps.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortFieldTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("created_date", SortField.FEEDBACK_CREATION_TIME.getQueryKey());
    assertEquals("updated_date", SortField.FEEDBACK_UPDATED_TIME.getQueryKey());
  }

}