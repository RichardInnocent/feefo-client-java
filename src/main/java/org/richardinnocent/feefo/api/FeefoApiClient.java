package org.richardinnocent.feefo.api;

import org.richardinnocent.feefo.api.requests.FeefoApiRequest;

public interface FeefoApiClient {
  String getBaseUrl();
  <R> R execute(FeefoApiRequest<R> request);
}
