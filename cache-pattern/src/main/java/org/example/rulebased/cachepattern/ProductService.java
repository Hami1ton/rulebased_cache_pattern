package org.example.rulebased.cachepattern;


import java.util.List;
import org.example.rulebased.cachepattern.ruleunit.Product;
import org.example.rulebased.cachepattern.ruleunit.ProductCacheService;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductService implements ProductCacheService{

    private ReactiveKeyCommands<String> keyCommands; 
    private ValueCommands<String, Product> productCommands; 

    public ProductService(RedisDataSource ds, ReactiveRedisDataSource reactive) { 
        productCommands = ds.value(Product.class);
        keyCommands = reactive.key();  
    }

    @Override
    public Product get(String productId) {
        Product value = productCommands.get(productId);
        if (value == null) {
            return null;
        }
        return value;
    }

    void set(String productId, Product product) {
        productCommands.set(productId, product); 
    }

    Uni<Void> del(String productId) {
        return keyCommands.del(productId).replaceWithVoid();
    }

    Uni<List<String>> keys() {
        return keyCommands.keys("*"); 
    }
}
