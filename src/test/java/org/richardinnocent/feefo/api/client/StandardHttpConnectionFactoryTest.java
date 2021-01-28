package org.richardinnocent.feefo.api.client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import org.junit.jupiter.api.Test;

class StandardHttpConnectionFactoryTest {

  @Test
  public void create_ValidUrl_ConnectionCreated() throws IOException {
    HttpURLConnection connection =
        StandardHttpConnectionFactory.getInstance().create("https://validurl.com");
    assertEquals("https://validurl.com", connection.getURL().toString());
  }

  @Test
  public void create_InvalidUrl_ExceptionThrown() {
    assertThrows(
        IOException.class,
        () -> StandardHttpConnectionFactory.getInstance().create("invalid url")
    );
  }

}