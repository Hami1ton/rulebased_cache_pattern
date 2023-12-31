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
    public Uni<List<String>> productIds() {
        return service.keys();
    }

    @POST
    public Product create(Product product) {
        service.set(product.productId, product);
        return product;
    }

    @GET
    @Path("/{productId}")
    public Product get(String productId) {
        return service.get(productId);
    }

    @DELETE
    @Path("/{productId}")
    public Uni<Void> delete(String productId) {
        return service.del(productId);
    }
}
