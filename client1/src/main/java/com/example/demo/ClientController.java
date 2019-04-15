package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by root on 19-4-15.
 */
@RestController
@Configuration
public class ClientController {
    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
    @RequestMapping(value = "/router",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        RestTemplate restTemplate = getTemplate();
        String forObject = restTemplate.getForObject("http://eureka-service1/person/1", String.class);
        return forObject;
    }
}
