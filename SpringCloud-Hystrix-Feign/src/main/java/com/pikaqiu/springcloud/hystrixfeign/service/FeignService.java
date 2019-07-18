package com.pikaqiu.springcloud.hystrixfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 吕梁山
 * @date 2019/7/18
 */
@FeignClient(value = "eureka-client",fallback = FeignServiceImpl.class)
public interface FeignService {
    @RequestMapping("test")
    String test(@RequestParam(value = "userName") String userName);
}
