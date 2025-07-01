package com.nisum.jest.orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient paymentGatewayClient;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testOrderEndpoint_withMockedGateway() {
        when(paymentGatewayClient.charge(anyDouble())).thenReturn(true);

        ResponseEntity<String> response = restTemplate.postForEntity("/orders", null, String.class);

        assertEquals(200, response.getStatusCodeValue());
        verify(paymentGatewayClient, times(1)).charge(anyDouble());
        assertEquals(true, orderService != null && orderRepository != null);
    }
}