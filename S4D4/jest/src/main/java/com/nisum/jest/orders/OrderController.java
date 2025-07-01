package com.nisum.jest.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService service) {
        this.orderService = service;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder() {
        boolean success = orderService.placeOrder(500.0);  // Assume fixed price for demo
        if (success) {
            return ResponseEntity.ok("Order placed successfully");
        } else {
            return ResponseEntity.status(500).body("Payment failed");
        }
    }
}
