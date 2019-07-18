package com.pikaqiu.springcloud.hystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudHystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixFeignApplication.class, args);
    }

}
