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
    private MessageDTO message;
    private OrderDTO order;

    public Integer getOneIndexedPageNumber() {
        if (offset == null || limit == null) {
            return null;
        }
        if (offset % limit != 0) {
            throw new IllegalStateException("Offset should be a multiple of limit.");
        }
        return 1 + (offset / limit);
    }

    public Integer getPageSize() {
        return limit;
    }
}
