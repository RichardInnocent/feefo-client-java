package org.richardinnocent.feefo.api.mapping;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
  public void serialize_ZonedDateTime_ValidJsonWritten() throws JsonProcessingException {
    ZonedDateTime dateTime = ZonedDateTime.of(2021, 1, 22, 16, 33, 23, 123456789, ZoneId.of("UTC"));
    String result = OBJECT_MAPPER.writeValueAsString(dateTime);
    assertEquals("\"2021-01-22T16:33:23.123456789\"", result);
  }

  @Test
  public void deserialize_ZonedDateTime_ValidDateTimeGenerated() throws JsonProcessingException {
    long millis = 1611333503023L;
    ZonedDateTime dateTime = OBJECT_MAPPER.readValue(Long.toString(millis), ZonedDateTime.class);
    assertEquals(2021, dateTime.getYear());
    assertEquals(Month.JANUARY, dateTime.getMonth());
    assertEquals(22, dateTime.getDayOfMonth());
    assertEquals(16, dateTime.getHour());
    assertEquals(38, dateTime.getMinute());
    assertEquals(23, dateTime.getSecond());
    assertEquals(23_000_000, dateTime.getNano());
  }

}