package org.richardinnocent.feefo.api.v10.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeFrameTest {

  @Test
  public void getQueryKey_All_AsExpected() {
    assertEquals("24_hours", TimeFrame.LAST_24_HOURS.getQueryKey());
    assertEquals("week", TimeFrame.LAST_WEEK.getQueryKey());
    assertEquals("month", TimeFrame.LAST_30_DAYS.getQueryKey());
    assertEquals("year", TimeFrame.LAST_YEAR.getQueryKey());
    assertEquals("all", TimeFrame.ALL.getQueryKey());
  }

}