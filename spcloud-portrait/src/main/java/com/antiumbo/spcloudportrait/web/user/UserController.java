package com.antiumbo.spcloudportrait.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author antiumbo
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return restTemplate.getForEntity("http://USER-SERVER/test", String.class).getBody();
    }
}
