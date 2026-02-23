package com.artbook.core.serialization;

import com.artbook.core.domain.ImageType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ImageTypeSerializer extends JsonSerializer<ImageType> {

    @Override
    public void serialize(ImageType imageType, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (imageType == null) {
            jg.writeNull();
        } else {
            jg.writeString(imageType.name());
        }
    }
}
