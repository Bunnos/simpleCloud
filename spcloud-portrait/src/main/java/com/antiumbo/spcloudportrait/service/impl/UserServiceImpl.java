package com.antiumbo.spcloudportrait.service.impl;

import com.antiumbo.spcloudportrait.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author antiumbo
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    @HystrixCommand(fallbackMethod = "userFallback")
    public String test() {
        return restTemplate.getForObject("http://USER-SERVER/test", String.class);
    }

    public String userFallback(){
        return "_error";
    }
}
