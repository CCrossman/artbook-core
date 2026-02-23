package com.artbook.core.serialization;

import com.artbook.core.domain.ImageType;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ImageTypeDeserializer extends JsonDeserializer<ImageType> {

    @Override
    public ImageType deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        String label = jp.getValueAsString();
        return ImageType.fromString(label);
    }
}
