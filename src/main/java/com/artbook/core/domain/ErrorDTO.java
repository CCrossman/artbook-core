package com.artbook.core.domain;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class ErrorDTO {
    private String type, message;
}
