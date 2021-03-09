package com.afikur.jmsexample.service;

import com.afikur.jmsexample.model.BookOrder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {
    private static final String BOOK_QUEUE = "book.order.queue";
    private final JmsTemplate jmsTemplate;

    public BookOrderService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(BookOrder bookOrder) {
        jmsTemplate.convertAndSend(BOOK_QUEUE, bookOrder);
    }
}
