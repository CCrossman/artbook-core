package com.artbook.core.domain;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class OrderPropertyDTO {
    private String property;
    private OrderDirection direction;
}
