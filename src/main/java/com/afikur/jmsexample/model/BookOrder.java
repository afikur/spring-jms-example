package com.afikur.jmsexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookOrder {
    private Long id;
    private Book book;
    private Customer customer;

    @JsonCreator
    public BookOrder(@JsonProperty("id") Long id,
                     @JsonProperty("book") Book book,
                     @JsonProperty("customer") Customer customer) {
        this.id = id;
        this.book = book;
        this.customer = customer;
    }
}
