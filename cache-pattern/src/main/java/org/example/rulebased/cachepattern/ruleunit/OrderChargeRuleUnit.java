package org.example.rulebased.cachepattern.ruleunit;

import org.drools.ruleunits.api.DataStream;
import org.drools.ruleunits.api.RuleUnitData;


public class OrderChargeRuleUnit implements RuleUnitData {

    private DataStream<Order> order;

    private DataStream<OrderCharge> orderCharge;

    private ProductCacheService productCacheService;

    public OrderChargeRuleUnit(ProductCacheService productCacheService) {
        this.productCacheService = productCacheService;
    }

    public void setOrder(DataStream<Order> order) {
        this.order = order;
    }

    public DataStream<Order> getOrder() {
        return order;
    }

    public void setOrderCharge(DataStream<OrderCharge> orderCharge) {
        this.orderCharge = orderCharge;
    }

    public DataStream<OrderCharge> getOrderCharge() {
        return orderCharge;
    }

    public ProductCacheService getProductCacheService() {
        // memo 
        // getterを用意しないとDRLの解析時エラーとなる
        return this.productCacheService;
    }    
}
