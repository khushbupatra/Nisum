package com.nisum.jest.orders;

import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayClient {
    public boolean charge(double amount) {
        System.out.println("Charging payment: " + amount);
        return true;
    }
}
