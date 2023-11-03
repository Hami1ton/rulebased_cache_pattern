package org.example.rulebased.cachepattern;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.example.rulebased.cachepattern.ruleunit.Order;
import org.example.rulebased.cachepattern.ruleunit.OrderCharge;
import org.example.rulebased.cachepattern.ruleunit.OrderChargeRuleUnit;
import org.example.rulebased.cachepattern.ruleunit.ProductCacheService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class OrderChargeCalculator {

    @Inject
    ProductCacheService service;

    public OrderChargeCalculator(ProductCacheService service) {
        this.service = service;
    }

    OrderCharge calculate(Order order) {

        OrderChargeRuleUnit ruleunit = new OrderChargeRuleUnit(service);
        RuleUnitInstance<OrderChargeRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(ruleunit);
        ruleunit.getOrder().append(order);

        // execute rule 
        instance.fire();

        OrderCharge orderCharge = null;
        var queryResult = instance.executeQuery("FindOrderCharge").toList();
        if (queryResult.size() == 1) {
            orderCharge = (OrderCharge) queryResult.get(0).get("$o");
        }
        instance.close();

        return orderCharge;
    }

}
