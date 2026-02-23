package com.artbook.core.domain;

import com.artbook.core.serialization.ImageTypeDeserializer;
import com.artbook.core.serialization.ImageTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = ImageTypeDeserializer.class)
@JsonSerialize(using = ImageTypeSerializer.class)
public enum ImageType {
    FULL,
    PREVIEW,
    THUMBNAIL,
    TWITTER;

    public static ImageType fromString(String imageTypeName) {
        for (ImageType imageType : values()) {
            if (imageType.name().equalsIgnoreCase(imageTypeName)) {
                return imageType;
            }
        }
        return null;
    }
}
