package com.github.hfantin.redisexample.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hfantin.redisexample.dto.Bundle;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;

@Startup
@Singleton
public class StartResource {

    @PostConstruct
    public void onStart() {
        System.out.println("startResource.onStart");
        ObjectMapper mapper = new ObjectMapper();
        Bundle bundle = new Bundle();
        bundle.setName("teste");
        try {
            final String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(List.of(bundle));
            System.out.println("json: \n" + s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
