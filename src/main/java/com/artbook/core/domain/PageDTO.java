package com.artbook.core.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@ToString
public class PageDTO<T> {
    private List<T> content;
    private Integer count, limit, offset;
    private ErrorDTO error;
    private OrderDTO order;
}
