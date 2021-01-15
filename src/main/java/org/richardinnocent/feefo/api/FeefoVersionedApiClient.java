package org.richardinnocent.feefo.api;

public interface FeefoVersionedApiClient extends FeefoApiClient {

  String getVersion();
  String getVersionedUrl();

}
