package org.richardinnocent.feefo.api.client;

import java.io.IOException;
import java.net.HttpURLConnection;

@FunctionalInterface
public interface HttpConnectionFactory {

  HttpURLConnection create(String url) throws IOException;

}
