package com.artbook.core.domain;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class ImageUploadDTO {
    private String globalId;
    private MessageDTO aggregation;
    private Map<ImageType, List<MessageDTO>> summaries;
}
