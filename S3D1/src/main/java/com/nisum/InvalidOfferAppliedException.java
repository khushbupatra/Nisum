package com.nisum;

public final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}
