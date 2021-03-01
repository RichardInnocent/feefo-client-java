package org.richardinnocent.feefo.api.v10.reviews.service.params;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SortFieldTest {

  @Test
  public void getQueryKey_Always_AsExpected() {
    assertEquals("created_date", SortField.FEEDBACK_CREATION_TIME.getQueryKey());
    assertEquals("updated_date", SortField.FEEDBACK_UPDATED_TIME.getQueryKey());
    assertEquals("helpful", SortField.HELPFUL_VOTES.getQueryKey());
    assertEquals("id", SortField.SERVICE_FEEDBACK_ID.getQueryKey());
  }

}
