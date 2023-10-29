package org.example.rulebased.cachepattern.ruleunit;

public class ProductCacheServiceMock implements ProductCacheService {

    @Override
    public Product get(String productId) {
        return new Product("1", "name", 100);
    }
}
