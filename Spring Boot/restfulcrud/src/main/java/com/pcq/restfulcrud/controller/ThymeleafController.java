package com.pcq.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {


    @RequestMapping("/success")
    public String sayHello() {
        return "success";
    }
}
