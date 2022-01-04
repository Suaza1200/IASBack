package com.example.demo.configuration.jackson.codecs;

import com.example.demo.domain.ProductPrice;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ProductPriceParser {
    public static class Serializer extends JsonSerializer<ProductPrice> {
        @Override
        public void serialize(ProductPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<ProductPrice> {
        @Override
        public ProductPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new ProductPrice(p.getValueAsString());
        }
    }
}
