package com.github.hfantin.redisexample;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;


@ApplicationScoped
public class Application {
    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object param) {
        System.out.println("Application.onStart");
    }
}
