package com.nisum;

public class Q6 {

    public void paymentMethod(String method, String offer) {
        if (!method.equalsIgnoreCase("Card") && !method.equalsIgnoreCase("UPI")) {
            throw new InvalidPaymentMethodException("Invalid payment method: " + method);
        }

        if (!offer.equalsIgnoreCase("None") && !offer.equalsIgnoreCase("DISCOUNT10")) {
            throw new InvalidOfferAppliedException("Invalid offer applied: " + offer);
        }

        System.out.println("Payment done using: " + method + " with offer: " + offer);
    }

    public void processPaymentMethod(String method, String offer) {
        try {
            paymentMethod(method, offer);
        } catch (PaymentException e) {
            if (e instanceof InvalidPaymentMethodException ipm) {
                System.out.println("Payment Error - Method: " + ipm.getMessage());
            } else if (e instanceof InvalidOfferAppliedException ioa) {
                System.out.println("Payment Error - Offer: " + ioa.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Q6 service = new Q6();

        service.processPaymentMethod("Card", "DISCOUNT10");
        service.processPaymentMethod("Cash", "None");
        service.processPaymentMethod("UPI", "XYZ");
    }
}

