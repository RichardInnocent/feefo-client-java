package org.richardinnocent.feefo.api.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Standard implementation of a {@link HttpConnectionFactory}.
 */
public class StandardHttpConnectionFactory implements HttpConnectionFactory {

  private static final StandardHttpConnectionFactory INSTANCE = new StandardHttpConnectionFactory();

  /**
   * Gets the singleton instance of this class.
   * @return The singleton instance.
   */
  public static StandardHttpConnectionFactory getInstance() {
    return INSTANCE;
  }

  @Override
  public HttpURLConnection create(String url) throws IOException {
    return (HttpURLConnection) new URL(url).openConnection();
  }
}
