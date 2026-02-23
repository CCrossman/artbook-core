package com.artbook.core.serialization;

import com.artbook.core.domain.OrderDirection;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class OrderDirectionSerializer extends JsonSerializer<OrderDirection> {

    @Override
    public void serialize(OrderDirection order, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (order == null) {
            jg.writeNull();
        } else {
            jg.writeString(order.name());
        }
    }
}
