package org.example.rulebased.cachepattern;

import org.example.rulebased.cachepattern.ruleunit.Order;
import org.example.rulebased.cachepattern.ruleunit.OrderCharge;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/order")
public class OrderResource {

    @Inject
    OrderChargeCalculator calculator;

    @POST
    public OrderCharge product(Order order) {
        return calculator.calculate(order);
    }

}
