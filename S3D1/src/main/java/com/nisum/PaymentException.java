package com.nisum;

public sealed class PaymentException extends RuntimeException
        permits InvalidPaymentMethodException, InvalidOfferAppliedException {

    public PaymentException(String message) {
        super(message);
    }
}