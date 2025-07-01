package com.nisum.jest.legacy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {

    @Test
    public void testGetPrice_whenTaxFails_returnsFallback() {
        PriceCalculator calculator = Mockito.mock(PriceCalculator.class);
        when(calculator.calculatePrice(100.0)).thenThrow(new ArithmeticException());

        PriceFacade facade = new PriceFacade(calculator);
        double result = facade.getPrice(100.0);

        assertEquals(0.0, result, 0.001);
        verify(calculator).calculatePrice(100.0);
    }

    @Test
    public void testGetPrice_afterReset_invokesRealMethod() {
        PriceCalculator spyCalculator = spy(new PriceCalculator());
        PriceFacade facade = new PriceFacade(spyCalculator);
        double result = facade.getPrice(100.0);
        assertEquals(118.0, result, 0.001);
        verify(spyCalculator).calculatePrice(100.0);
    }
}
