package org.example.rulebased.cachepattern.ruleunit;

import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;


public class OrderAmountRuleUnit implements RuleUnitData {

    private DataStream<Order> order;

    private DataStream<OrderAmount> orderAmount;

    public void setOrder(DataStream<Order> order) {
        this.order = order;
    }

    public DataStream<Order> getOrder() {
        return order;
    }

    public void setOrderAmount(DataStream<OrderAmount> orderAmount) {
        this.orderAmount = orderAmount;
    }

    public DataStream<OrderAmount> getOrderAmount() {
        return orderAmount;
    }
    
}
