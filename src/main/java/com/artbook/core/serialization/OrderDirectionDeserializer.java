package com.artbook.core.serialization;

import com.artbook.core.domain.OrderDirection;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class OrderDirectionDeserializer extends JsonDeserializer<OrderDirection> {

    @Override
    public OrderDirection deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        String label = jp.getValueAsString();
        return OrderDirection.fromLabel(label);
    }
}
