package com.artbook.core.domain;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class MessageDTO {
    private MessageType type;
    private String classification, message;
}
