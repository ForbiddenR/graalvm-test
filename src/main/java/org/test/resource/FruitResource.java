package org.test.resource;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.sqlclient.Pool;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.test.orm.Fruit;

@Path("fruits")
public class FruitResource {
    private final Pool client;

    public FruitResource(Pool client) {
        this.client = client;
    }

    @GET
    public Multi<Fruit> get() {
        return Fruit.findAll(client);
    }

}
