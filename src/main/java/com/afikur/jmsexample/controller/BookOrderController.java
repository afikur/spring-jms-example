package com.afikur.jmsexample.controller;

import com.afikur.jmsexample.model.Book;
import com.afikur.jmsexample.model.BookOrder;
import com.afikur.jmsexample.model.Customer;
import com.afikur.jmsexample.service.BookOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookOrderController {
    private final BookOrderService bookOrderService;

    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    @GetMapping("/bookOrder")
    public ResponseEntity<String> orderBook() {
        Book book = new Book(1L, "Sample Book");
        Customer customer = new Customer(1L, "Afikur Rahman", "Khan");
        BookOrder bookOrder = new BookOrder(1L, book, customer);
        try {
            bookOrderService.send(bookOrder);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
