package com.nisum;

public final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}