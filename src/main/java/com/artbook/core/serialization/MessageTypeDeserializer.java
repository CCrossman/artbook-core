package com.artbook.core.serialization;

import com.artbook.core.domain.MessageType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class MessageTypeDeserializer extends JsonDeserializer<MessageType> {

    @Override
    public MessageType deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        String label = jp.getValueAsString();
        return MessageType.fromString(label);
    }
}
