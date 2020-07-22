package com.example.pcq.springboot_yaml;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringbootYamlApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootYamlApplication.class, args);
    }


    public void sayHello() {

    }

}
