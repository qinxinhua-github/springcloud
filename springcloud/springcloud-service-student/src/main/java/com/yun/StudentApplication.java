package com.yun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //当前使用eureka的server
//@EnableFeignClients
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class,args);
    }
}
