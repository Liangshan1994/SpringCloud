package com.pikaqiu.springcloud.hystrixfeign.controller;

import com.pikaqiu.springcloud.hystrixfeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕梁山
 * @date 2019/7/18
 */
@RestController
public class TestController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("test")
    public String test(String userName){
        return feignService.test(userName);
    }
}
