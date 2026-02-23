package com.artbook.core.domain;

import lombok.*;
import org.springframework.core.io.Resource;

import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class ImageDTO {
    private Long imageId;
    private ImageType imageType;
    private String title;
    private String description;
    private Integer likes;
    private Boolean liked;
    private List<ImageTag> tags;
    private Resource resource;
    private String contentType;
}