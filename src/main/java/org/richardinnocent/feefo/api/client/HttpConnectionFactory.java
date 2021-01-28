package org.richardinnocent.feefo.api.client;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Responsible for creating {@link HttpURLConnection}s based on a given URL. This functions as a
 * facade for creating these connections - the standard Java implementation of creating a URL and
 * then creating a connection from this new object makes it difficult to test. This object can be
 * injected wherever that functionality is required.
 */
@FunctionalInterface
public interface HttpConnectionFactory {

  /**
   * Creates a {@link HttpURLConnection} based on the given URL.
   * @param url The URL.
   * @return The connection.
   * @throws IOException Thrown if there is a problem creating the URL, e.g. the URL is not valid.
   */
  HttpURLConnection create(String url) throws IOException;

}
