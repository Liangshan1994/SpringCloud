package com.pikaqiu.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕梁山
 * @date 2019/7/17
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("test")
    public String test(String userName){
        return "此次服务端口号：" + port + ",接收到的参数：" + userName;
    }
}
