package com.github.hfantin.redisexample.resources;

import com.github.hfantin.redisexample.pool.FromJedisPool;
import redis.clients.jedis.Jedis;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import java.util.Set;

@Path("/redis")
public class RedisResource {

    @Inject
    @FromJedisPool
    private Jedis jedisPool;

    @GET
    @Path("{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("key") String key) {
        String value = jedisPool.get(key);
        return Response.ok(Map.of(key, value != null ? value : "invalid key")).build();
    }

    @POST
    @Path("{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("key") String key, String value) {
        jedisPool.set(key, value);
        return Response.ok(Map.of(key, value)).build();
    }

    @GET
    @Path("/keys/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listKeys(@PathParam("key") String key) {
        Set<String> value = jedisPool.keys(key);
        return Response.ok(value).build();
    }

}
