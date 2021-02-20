package org.richardinnocent.feefo.api.mapping;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZoneOffset;
import java.time.OffsetDateTime;
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
  public void serialize_OffsetDateTime_ValidJsonWritten() throws JsonProcessingException {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 1, 22, 16, 33, 23, 123456789, ZoneOffset.UTC);
    String result = OBJECT_MAPPER.writeValueAsString(dateTime);
    assertEquals("\"2021-01-22T16:33:23.123456789\"", result);
  }

  @Test
  public void deserialize_EpochTime_ValidDateTimeGenerated() throws JsonProcessingException {
    long millis = 1611333503023L;
    OffsetDateTime dateTime = OBJECT_MAPPER.readValue(Long.toString(millis), OffsetDateTime.class);
    assertEquals(2021, dateTime.getYear());
    assertEquals(Month.JANUARY, dateTime.getMonth());
    assertEquals(22, dateTime.getDayOfMonth());
    assertEquals(16, dateTime.getHour());
    assertEquals(38, dateTime.getMinute());
    assertEquals(23, dateTime.getSecond());
    assertEquals(23_000_000, dateTime.getNano());
  }

  @Test
  public void deserialize_Timestamp_ValidDateTimeGenerated() throws JsonProcessingException {
    String timestamp = "\"2021-02-20T17:03:01.030Z\"";
    OffsetDateTime dateTime = OBJECT_MAPPER.readValue(timestamp, OffsetDateTime.class);
    assertEquals(2021, dateTime.getYear());
    assertEquals(Month.FEBRUARY, dateTime.getMonth());
    assertEquals(20, dateTime.getDayOfMonth());
    assertEquals(17, dateTime.getHour());
    assertEquals(3, dateTime.getMinute());
    assertEquals(1, dateTime.getSecond());
    assertEquals(30_000_000, dateTime.getNano());
  }

}