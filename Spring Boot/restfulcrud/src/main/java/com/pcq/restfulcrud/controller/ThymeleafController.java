package com.pcq.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ThymeleafController {


    @RequestMapping("/success")
    public String sayHello(Map<String, Object> map) {
        map.put("success", "成功");
        map.put("list", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }


    @RequestMapping("/logging")
    public String logging() {
        return "logging";
    }
}
