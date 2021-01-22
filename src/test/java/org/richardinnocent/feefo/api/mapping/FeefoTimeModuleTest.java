package org.richardinnocent.feefo.api.mapping;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FeefoTimeModuleTest {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @BeforeAll
  public static void setUp() {
    OBJECT_MAPPER.registerModule(FeefoTimeModule.getInstance());
  }

  @Test
  public void serialize_LocalDateTime_ValidJsonWritten() throws JsonProcessingException {
    LocalDateTime dateTime = LocalDateTime.of(2021, 1, 22, 16, 33, 23, 123456789);
    String result = OBJECT_MAPPER.writeValueAsString(dateTime);
    assertEquals("\"2021-01-22T16:33:23.123456789\"", result);
  }

  @Test
  public void deserialize_LocalDateTime_ValidLocalDateTimeGenerated() throws JsonProcessingException {
    long millis = 1611333503023L;
    LocalDateTime dateTime = OBJECT_MAPPER.readValue(Long.toString(millis), LocalDateTime.class);
    assertEquals(2021, dateTime.getYear());
    assertEquals(Month.JANUARY, dateTime.getMonth());
    assertEquals(22, dateTime.getDayOfMonth());
    assertEquals(16, dateTime.getHour());
    assertEquals(38, dateTime.getMinute());
    assertEquals(23, dateTime.getSecond());
    assertEquals(23000, dateTime.getNano());
  }

}