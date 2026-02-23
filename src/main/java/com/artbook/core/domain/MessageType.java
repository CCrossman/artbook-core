package com.artbook.core.domain;

import com.artbook.core.serialization.MessageTypeDeserializer;
import com.artbook.core.serialization.MessageTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = MessageTypeDeserializer.class)
@JsonSerialize(using = MessageTypeSerializer.class)
public enum MessageType {
    ERROR, INFO;

    public static MessageType fromString(String messageTypeName) {
        for (MessageType messageType : values()) {
            if (messageType.name().equalsIgnoreCase(messageTypeName)) {
                return messageType;
            }
        }
        return null;
    }
}
