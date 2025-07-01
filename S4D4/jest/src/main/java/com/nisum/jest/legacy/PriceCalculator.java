package com.nisum.jest.legacy;

public class PriceCalculator {
    public double calculatePrice(double basePrice) {
        double tax = calculateTax(basePrice);
        return basePrice + tax;
    }

    protected double calculateTax(double basePrice) {
        return basePrice * 0.18;
    }
}
