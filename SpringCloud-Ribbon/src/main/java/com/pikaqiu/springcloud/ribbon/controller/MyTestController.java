package com.pikaqiu.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 吕梁山
 * @date 2019/7/16
 */
@RestController
public class MyTestController {

    private String service = "http://eureka-client";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test")
    public String test(String userName){
        return restTemplate.getForObject(service + "/test?userName=" + userName, String.class);
    }

}
