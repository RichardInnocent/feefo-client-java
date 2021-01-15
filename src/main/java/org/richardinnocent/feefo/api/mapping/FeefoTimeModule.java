package org.richardinnocent.feefo.api.mapping;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FeefoTimeModule extends SimpleModule {

  private static final FeefoTimeModule INSTANCE = new FeefoTimeModule();
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  FeefoTimeModule() {
    addSerializer(new LocalDateTimeSerializer());
    addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
  }

  public static FeefoTimeModule getInstance() {
    return INSTANCE;
  }

  private static class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

    private LocalDateTimeSerializer() {
      super(LocalDateTime.class);
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
      jsonGenerator.writeString(localDateTime.atOffset(ZoneOffset.UTC).format(DATE_TIME_FORMATTER));
    }
  }

  private static class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private LocalDateTimeDeserializer() {
      super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser,
                                     DeserializationContext deserializationContext)
        throws IOException {
      long epochTime = jsonParser.getValueAsLong();
      long seconds = epochTime / 1000L;
      int nanos = (int) (epochTime % 1000L * 1000L);
      return LocalDateTime.ofEpochSecond(seconds, nanos, ZoneOffset.UTC);
    }
  }

}
