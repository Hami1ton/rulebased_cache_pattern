package org.example.rulebased.cachepattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.rulebased.cachepattern.ruleunit.Order;
import org.example.rulebased.cachepattern.ruleunit.OrderAmount;
import org.junit.jupiter.api.Test;


public class OrderAmountCalculatorTest {

    OrderAmountCalculator calculator = new OrderAmountCalculator();

    @Test
    public void 料金計算_注文なし() {

        Order order = new Order("1", 0);
        OrderAmount amount = calculator.calculate(order);
        
        // assert
        OrderAmount expected = new OrderAmount(0);
        assertEquals(expected, amount);
    }

    @Test
    public void 料金計算_注文単数() {

        Order order = new Order("1", 1);
        OrderAmount amount = calculator.calculate(order);
        
        // assert
        OrderAmount expected = new OrderAmount(100);
        assertEquals(expected, amount);
    }
}
