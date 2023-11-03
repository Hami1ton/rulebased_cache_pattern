package org.example.rulebased.cachepattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.rulebased.cachepattern.ruleunit.Order;
import org.example.rulebased.cachepattern.ruleunit.OrderCharge;
import org.example.rulebased.cachepattern.ruleunit.ProductCacheServiceMock;
import org.junit.jupiter.api.Test;


public class OrderChargeCalculatorTest {


    ProductCacheServiceMock mock = new ProductCacheServiceMock();
    OrderChargeCalculator calculator = new OrderChargeCalculator(mock);

    @Test
    public void 料金計算_注文なし() {
        Order order = new Order("1", 0);
        OrderCharge charge = calculator.calculate(order);
        // assert
        OrderCharge expected = new OrderCharge(0);
        assertEquals(expected, charge);
    }

    @Test
    public void 料金計算_注文個数単数() {

        Order order = new Order("1", 1);
        OrderCharge charge = calculator.calculate(order);
        
        // assert
        OrderCharge expected = new OrderCharge(100);
        assertEquals(expected, charge);
    }

    @Test
    public void 料金計算_注文個数複数() {

        Order order = new Order("1", 2);
        OrderCharge charge = calculator.calculate(order);
        
        // assert
        OrderCharge expected = new OrderCharge(200);
        assertEquals(expected, charge);
    }
}
