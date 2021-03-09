package com.afikur.jmsexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;

    @JsonCreator
    public Customer(@JsonProperty("id") Long id,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
