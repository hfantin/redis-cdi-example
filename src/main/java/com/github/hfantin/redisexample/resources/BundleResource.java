package com.github.hfantin.redisexample.resources;

import com.github.hfantin.redisexample.dto.Bundle;
import com.github.hfantin.redisexample.pool.FromJedisPool;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/v1/bundles")
public class BundleResource {

    private static final String BUNDLE_PREFIX = "bundle";

    @Inject
    @FromJedisPool
    private Jedis jedisPool;


    @GET
    @Path("/{os}/{version}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBundle(@PathParam("os") String os, @PathParam("version") final String version) {
        System.out.println("getBundle: " + os + ", " + version);
        String key = getKey(os, version);
        String value =  jedisPool.get(key);
        return Response.ok(new Gson().fromJson(value, Bundle.class)).build();
    }

    @POST
    @Path("/{os}/{version}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBundle(@PathParam("os") String os, @PathParam("version") final String version, final Bundle bundle) {
        String value  = new Gson().toJson(bundle);
        String key = getKey(os, version);
        System.out.println("postBundle: " + os + ", " + version + ", " + bundle);
        jedisPool.set(key, value);
        return Response.ok(key).build();
    }

    private String getKey(String os, String version) {
        return String.format("%s::%s::%s", BUNDLE_PREFIX, os, version);
    }
}
