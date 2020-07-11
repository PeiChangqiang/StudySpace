package com.example.pcq.springboot_yaml.config;

import com.example.pcq.springboot_yaml.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指明当前类是配置类
 */
@Configuration
public class Myconfig {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
