package com.afikur.jmsexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessagePublishController {
    private final JmsTemplate jmsTemplate;

    public MessagePublishController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<Map<String, String>> publishMessage(@PathVariable String message) {
        try {
            jmsTemplate.convertAndSend("my-queue", message);

            Map<String, String> map = new HashMap<>();
            map.put("message", "Message Sent Successfully");

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("message", e.getMessage());

            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
