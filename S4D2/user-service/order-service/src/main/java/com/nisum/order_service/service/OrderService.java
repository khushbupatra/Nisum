package com.nisum.order_service.service;

import com.nisum.order_service.model.Order;
//import com.nisum.order_service.model.User;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OrderService {

    private final Map<Long, Order> orderMap = new HashMap<>();
    private long nextOrderId = 3;
    private final RestTemplate restTemplate;
    private static final String USER_SERVICE_URL = "http://localhost:8081/api/users/";

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        orderMap.put(1L, new Order(1L, 1L, "Laptop"));
        orderMap.put(2L, new Order(2L, 2L, "Monitor"));
    }

    public Map<String, Object> getOrderWithUser(Long orderId) {
        Order order = orderMap.get(orderId);
        if (order == null) return null;

        User user = restTemplate.getForObject(USER_SERVICE_URL + order.getUserId(), User.class);

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("user", user);
        return response;
    }

    public Map<String, Object> createOrder(Order order) {
        order.setId(nextOrderId++);
        orderMap.put(order.getId(), order);

        User user = restTemplate.getForObject(USER_SERVICE_URL + order.getUserId(), User.class);

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("user", user);
        return response;
    }
}