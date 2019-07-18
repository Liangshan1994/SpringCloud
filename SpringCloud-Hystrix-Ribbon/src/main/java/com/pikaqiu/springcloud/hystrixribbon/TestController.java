package com.pikaqiu.springcloud.hystrixribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 吕梁山
 * @date 2019/7/18
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    private String service = "http://eureka-client";

    @RequestMapping("test")
    @HystrixCommand(fallbackMethod = "testErrorMethod")
    public String test(String userName){
        return restTemplate.getForObject(service + "/test?userName=" + userName, String.class);
    }

    public String testErrorMethod(String userName){
        return "这是服务报错返回";
    }
}
