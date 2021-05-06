package com.github.hfantin.redisexample.resources;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartResource {

    @PostConstruct
    public void onStart() {
        System.out.println("startResource.onStart");
    }
}
