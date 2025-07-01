package com.nisum.jest.orders;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentGatewayClient paymentGatewayClient;
    private final OrderRepository orderRepository;

    public OrderService(PaymentGatewayClient client, OrderRepository repo) {
        this.paymentGatewayClient = client;
        this.orderRepository = repo;
    }

    public boolean placeOrder(double amount) {
        boolean paymentSuccess = paymentGatewayClient.charge(amount);
        if (paymentSuccess) {
            orderRepository.save("ORDER123");  // Dummy order ID for example
            return true;
        }
        return false;
    }
}
