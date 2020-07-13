package com.pcq.restfulcrud.config;


import com.pcq.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/test").setViewName("success");
    }


    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
