package org.example.rulebased.cachepattern;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("/order")
public class OrderResource {

    @GET
    @Path("/product")
    public String product() {
        return "Hello from RESTEasy Reactive";
    }

}
