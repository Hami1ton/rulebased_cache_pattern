package org.example.rulebased.cachepattern;

import java.util.List;

import org.example.rulebased.cachepattern.ruleunit.Product;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("/products")
public class ProductResource {

    @Inject
    ProductService service;

    @GET
    public Uni<List<String>> keys() {
        return service.keys();
    }

    @POST
    public Product create(Product product) {
        service.set(product.key, product);
        return product;
    }

    @GET
    @Path("/{key}")
    public Product get(String key) {
        return service.get(key);
    }

    @DELETE
    @Path("/{key}")
    public Uni<Void> delete(String key) {
        return service.del(key);
    }
}
