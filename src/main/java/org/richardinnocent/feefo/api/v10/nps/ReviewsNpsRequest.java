package org.richardinnocent.feefo.api.v10.nps;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;

public class ReviewsNpsRequest extends FeefoApiGetRequest<Map<String, ?>> {

  private final String merchantIdentifier;

  public ReviewsNpsRequest(String merchantIdentifier) {
    super(new TypeReference<Map<String, ?>>(){});
    this.merchantIdentifier =
        Objects.requireNonNull(merchantIdentifier, "Merchant identifier must be specified");
  }

  @Override
  public String getBasePath() {
    return "reviews/nps";
  }

  @Override
  protected Map<String, String> getRequestParameters() {
    return Collections.singletonMap("merchant_identifier", merchantIdentifier);
  }

  @Override
  public boolean isVersioned() {
    return true;
  }

  @Override
  public boolean requiresAuthentication() {
    return true;
  }
}
