package com.pikaqiu.springcloud.hystrixfeign.service;


import org.springframework.stereotype.Component;

/**
 * @author 吕梁山
 * @date 2019/7/18
 */
@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String test(String userName) {
        return "这是服务报错返回";
    }
}
