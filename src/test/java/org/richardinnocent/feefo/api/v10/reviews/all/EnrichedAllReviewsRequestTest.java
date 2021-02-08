package org.richardinnocent.feefo.api.v10.reviews.all;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

class EnrichedAllReviewsRequestTest {

  @Test
  public void constructor_MerchantIdentifierIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new EnrichedAllReviewsRequest(null));
  }

  @Test
  public void getBasePath_Always_AsExpected() {
    assertEquals("/10/reviews/all", new EnrichedAllReviewsRequest("test-merchant").getBasePath());
  }

  @Test
  public void getRequestParameters_Always_SpecifiesMerchantIdentifier() {
    String merchantIdentifier = "test-merchant";
    Map<String, String> expectedParameters =
        Collections.singletonMap("merchant_identifier", merchantIdentifier);
    assertEquals(
        expectedParameters,
        new EnrichedAllReviewsRequest(merchantIdentifier).getRequestParameters()
    );
  }

  @Test
  public void requiresAuthentication_Always_ReturnsTrue() {
    assertTrue(new EnrichedAllReviewsRequest("test-merchant").requiresAuthentication());
  }

}