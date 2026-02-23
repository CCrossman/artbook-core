package com.artbook.core.serialization;

import com.artbook.core.domain.MessageType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MessageTypeSerializer extends JsonSerializer<MessageType> {

    @Override
    public void serialize(MessageType messageType, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (messageType == null) {
            jg.writeNull();
        } else {
            jg.writeString(messageType.name());
        }
    }
}
