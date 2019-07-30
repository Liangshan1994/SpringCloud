package com.pikaqiu.springcloud.configclientbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕梁山
 * @date 2019/7/24
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/test")
    public String test(){
        return "配置中的hello值为：" + hello;
    }
}
