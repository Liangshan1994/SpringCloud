package com.pikaqiu.springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 吕梁山
 * @date 2019/7/17
 */
@FeignClient("eureka-client")
public interface FeignService {

    @RequestMapping("test")
    String test(String userName);
}
