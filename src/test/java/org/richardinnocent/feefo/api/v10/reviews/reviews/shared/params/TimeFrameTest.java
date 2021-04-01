package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.params;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeFrameTest {

  @Test
  public void getQueryKey_All_AsExpected() {
    assertEquals("24_hours", TimeFrame.LAST_24_HOURS.getQueryValue());
    assertEquals("week", TimeFrame.LAST_WEEK.getQueryValue());
    assertEquals("month", TimeFrame.LAST_30_DAYS.getQueryValue());
    assertEquals("year", TimeFrame.LAST_YEAR.getQueryValue());
    assertEquals("all", TimeFrame.ALL.getQueryValue());
  }

}