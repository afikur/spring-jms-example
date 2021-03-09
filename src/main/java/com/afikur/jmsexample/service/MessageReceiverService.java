package com.afikur.jmsexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiverService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiverService.class);

    @JmsListener(destination = "my-queue")
    public void messageListener(String message) {
        LOGGER.info("Message received! {}", message);
    }
}
