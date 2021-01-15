package org.richardinnocent.feefo.api.v10.nps;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;

public class ReviewsNpsRequest extends FeefoApiGetRequest<Map<String, ?>> {

  public ReviewsNpsRequest(String merchantIdentifier) {
    super(
        new TypeReference<Map<String, ?>>(){},
        Collections.singletonMap("merchant_identifier", merchantIdentifier)
    );
  }

  @Override
  public String getBasePath() {
    return "reviews/nps";
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
