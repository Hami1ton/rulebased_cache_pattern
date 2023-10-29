package org.example.rulebased.cachepattern;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.rulebased.cachepattern.ruleunit.Order;
import org.example.rulebased.cachepattern.ruleunit.OrderAmount;
import org.example.rulebased.cachepattern.ruleunit.OrderAmountRuleUnit;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class OrderAmountCalculator {

    OrderAmount calculate(Order order) {

        OrderAmountRuleUnit ruleunit = new OrderAmountRuleUnit();
        RuleUnitInstance<OrderAmountRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(ruleunit);
        ruleunit.getOrder().append(order);

        // execute rule 
        instance.fire();

        OrderAmount orderAmount = null;
        var queryResult = instance.executeQuery("FindOrderAmount").toList();
        if (queryResult.size() == 1) {
            orderAmount = (OrderAmount) queryResult.get(0).get("$o");
        }
        instance.close();

        return orderAmount;
    }

}
