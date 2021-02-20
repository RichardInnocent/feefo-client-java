package org.richardinnocent.feefo.api.mapping;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Responsible for serialising/deserialising dates/times sent in/from requests and responses to/from
 * the Feefo API.
 */
public class FeefoTimeModule extends SimpleModule {

  private static final FeefoTimeModule INSTANCE = new FeefoTimeModule();
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  private FeefoTimeModule() {
    addSerializer(new ZonedDateTimeSerializer());
    addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
  }

  /**
   * Gets the module singleton instance.
   * @return The module singleton instance.
   */
  public static FeefoTimeModule getInstance() {
    return INSTANCE;
  }

  private static class ZonedDateTimeSerializer extends StdSerializer<ZonedDateTime> {

    private ZonedDateTimeSerializer() {
      super(ZonedDateTime.class);
    }

    @Override
    public void serialize(ZonedDateTime zonedDateTime, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
      jsonGenerator.writeString(zonedDateTime.format(DATE_TIME_FORMATTER));
    }
  }

  private static class ZonedDateTimeDeserializer extends StdDeserializer<ZonedDateTime> {
    private ZonedDateTimeDeserializer() {
      super(ZonedDateTime.class);
    }

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser,
                                     DeserializationContext deserializationContext)
        throws IOException {
      String value = jsonParser.getValueAsString();
      return isEpochTime(value) ? getFromEpochTime(Long.parseLong(value)) : getFromTimestamp(value);
    }

    private boolean isEpochTime(CharSequence charSequence) {
      return charSequence.chars().allMatch(Character::isDigit);
    }

    private ZonedDateTime getFromEpochTime(long millis) {
      return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("UTC"));
    }

    private ZonedDateTime getFromTimestamp(String timestamp) {
      return ZonedDateTime.parse(timestamp);
    }
  }
}
