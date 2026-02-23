package com.artbook.core.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class OrderDTO {
    private List<OrderPropertyDTO> properties;
}
