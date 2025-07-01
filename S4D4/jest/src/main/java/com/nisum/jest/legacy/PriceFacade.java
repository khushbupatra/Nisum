package com.nisum.jest.legacy;

public class PriceFacade {

    private final PriceCalculator calculator;

    public PriceFacade(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    public double getPrice(double basePrice) {
        try {
            return calculator.calculatePrice(basePrice);
        } catch (ArithmeticException e) {
            return 0.0;
        }
    }

    public PriceCalculator getCalculator() {
        return calculator;
    }
}
