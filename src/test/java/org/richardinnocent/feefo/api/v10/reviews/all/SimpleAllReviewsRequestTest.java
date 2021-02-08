package org.richardinnocent.feefo.api.v10.reviews.all;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SimpleAllReviewsRequestTest {

  @Test
  public void constructor_MerchantIdentifierIsNull_ExceptionThrown() {
    assertThrows(NullPointerException.class, () -> new SimpleAllReviewsRequest(null));
  }

  @Test
  public void getBasePath_Always_AsExpected() {
    assertEquals("/10/reviews/all", new SimpleAllReviewsRequest("test-merchant").getBasePath());
  }

  @Test
  public void getRequestParameters_Always_ContainsMerchantIdentifier() {
    String merchantIdentifier = "test-merchant";
    Map<String, String> requestParameters =
        Collections.singletonMap("merchant_identifier", merchantIdentifier);
    assertEquals(
        requestParameters,
        new SimpleAllReviewsRequest(merchantIdentifier).getRequestParameters()
    );
  }

  @Test
  public void requiresAuthentication_Always_False() {
    assertFalse(new SimpleAllReviewsRequest("test-merchant").requiresAuthentication());
  }

}