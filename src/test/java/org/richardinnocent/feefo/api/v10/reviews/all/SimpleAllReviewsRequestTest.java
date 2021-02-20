package org.richardinnocent.feefo.api.v10.reviews.all;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.requests.EqualityOperator;
import org.richardinnocent.feefo.api.requests.QueryParameter;

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
    Collection<QueryParameter> expectedParameters = Collections.singletonList(
        new QueryParameter("merchant_identifier", EqualityOperator.EQUALS, merchantIdentifier)
    );
    assertEquals(
        expectedParameters,
        new SimpleAllReviewsRequest(merchantIdentifier).getQueryParameters()
    );
  }

  @Test
  public void requiresAuthentication_Always_False() {
    assertFalse(new SimpleAllReviewsRequest("test-merchant").requiresAuthentication());
  }

}