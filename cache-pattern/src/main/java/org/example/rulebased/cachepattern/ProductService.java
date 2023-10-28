package org.example.rulebased.cachepattern;


import java.util.List;
import org.example.rulebased.cachepattern.ruleunit.Product;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProductService {

    private ReactiveKeyCommands<String> keyCommands; 
    private ValueCommands<String, Product> productCommands; 

    public ProductService(RedisDataSource ds, ReactiveRedisDataSource reactive) { 
        productCommands = ds.value(Product.class); 
        keyCommands = reactive.key();  
    }

    Product get(String key) {
        Product value = productCommands.get(key); 
        if (value == null) {
            return null;
        }
        return value;
    }

    void set(String key, Product product) {
        productCommands.set(key, product); 
    }

    Uni<Void> del(String key) {
        return keyCommands.del(key).replaceWithVoid();
    }

    Uni<List<String>> keys() {
        return keyCommands.keys("*"); 
    }
    
}
