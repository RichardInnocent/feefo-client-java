package org.richardinnocent.feefo.api.v10.reviews.all;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.richardinnocent.feefo.api.requests.EqualityOperator;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;
import org.richardinnocent.feefo.api.requests.QueryParameter;

public class SimpleAllReviewsRequest extends FeefoApiGetRequest<SimpleAllReviewsResponse> {

  private final String merchantIdentifier;

  public SimpleAllReviewsRequest(String merchantIdentifier) throws NullPointerException {
    super(new TypeReference<SimpleAllReviewsResponse>(){});
    this.merchantIdentifier =
        Objects.requireNonNull(merchantIdentifier, "Merchant identifier must be specified");
  }

  @Override
  public String getBasePath() {
    return "/10/reviews/all";
  }

  @Override
  protected Collection<QueryParameter> getQueryParameters() {
    return Collections.singletonList(new QueryParameter("merchant_identifier", EqualityOperator.EQUALS, merchantIdentifier));
  }

  @Override
  public boolean requiresAuthentication() {
    return false;
  }

}
