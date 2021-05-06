package com.github.hfantin.redisexample.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@ApplicationScoped
public class PooledJedisProducer {

    private JedisPool pool = null;

    /**
     * sets up the pool.. invoked only once since bean is ApplicaitionScoped
     */
    @PostConstruct
    public void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);
        config.setMaxWaitMillis(5000);
        String total = System.getenv().getOrDefault("REDIS_MAX_TOTAL", "15");
        config.setMaxTotal(Integer.parseInt(total));
        String redisHost = System.getenv().getOrDefault("REDIS_HOST", "localhost");
        String redisPort = System.getenv().getOrDefault("REDIS_PORT", "6379");
        pool = new JedisPool(config, redisHost, Integer.valueOf(redisPort), 10000);
        System.out.println("Jedis Pool initialized");
    }


    @RequestScoped
    @Produces
    @FromJedisPool
    public Jedis get() {
        return pool.getResource();
    }

    public void backToPool(@Disposes @FromJedisPool Jedis jedis) {
        pool.returnResource(jedis);
    }

    @PreDestroy
    public void close() {
        pool.close();
        System.out.println("Jedis pool shutdown");
    }
}
