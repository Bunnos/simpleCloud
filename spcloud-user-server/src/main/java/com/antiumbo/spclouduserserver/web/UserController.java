package com.antiumbo.spclouduserserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


/**
 * @author antiumbo
 */
@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        try {
            int i =new Random().nextInt(3000);
            System.out.println(i);
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PORTRAIT");
        logger.info("service_id:"+instances.get(0).getServiceId());
        return "test1";
    }
}
