package com.nisum.jest.orders;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public void save(String orderId) {
        System.out.println("Saving order: " + orderId);
    }
}
