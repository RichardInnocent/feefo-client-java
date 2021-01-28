package org.richardinnocent.feefo.api.v10.reviews.all;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;

public class AllReviewsRequest extends FeefoApiGetRequest<ReviewsNpsResponse> {

  private final String merchantIdentifier;

  public AllReviewsRequest(String merchantIdentifier) {
    super(new TypeReference<ReviewsNpsResponse>(){});
    this.merchantIdentifier =
        Objects.requireNonNull(merchantIdentifier, "Merchant identifier must be specified");
  }

  @Override
  public String getBasePath() {
    return "/10/reviews/all";
  }

  @Override
  protected Map<String, String> getRequestParameters() {
    return Collections.singletonMap("merchant_identifier", merchantIdentifier);
  }

  @Override
  public boolean requiresAuthentication() {
    return false;
  }
}
