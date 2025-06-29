package com.nisum.order_service.model;

public class Order {
    private Long id;
    private Long userId;
    private String product;

    public Order() {}
    public Order(Long id, Long userId, String product) {
        this.id = id; this.userId = userId; this.product = product;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}