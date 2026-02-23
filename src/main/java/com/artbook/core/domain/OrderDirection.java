package com.artbook.core.domain;

import com.artbook.core.serialization.OrderDirectionDeserializer;
import com.artbook.core.serialization.OrderDirectionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;

@JsonDeserialize(using = OrderDirectionDeserializer.class)
@JsonSerialize(using = OrderDirectionSerializer.class)
public enum OrderDirection {
    ASC("asc", "ascending"),
    DESC("desc", "descending"),
    UNKNOWN("unknown");

    private final Set<String> labels;

    private OrderDirection(String... labels) {
        this.labels = Set.of(labels);
    }

    public static OrderDirection fromLabel(String label) {
        for (OrderDirection orderDirection : values()) {
            for (String lbl : orderDirection.labels) {
                if (lbl.equalsIgnoreCase(label)) {
                    return orderDirection;
                }
            }
        }
        return UNKNOWN;
    }
}
