package com.afikur.jmsexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;

    @JsonCreator
    public Book(@JsonProperty("id") Long id,
                @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }
}
