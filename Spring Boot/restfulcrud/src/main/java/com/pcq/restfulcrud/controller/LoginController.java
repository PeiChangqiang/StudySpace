package com.pcq.restfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {

    @PostMapping("/user/login")
    //@RequestMapping(value="/user/login", method= RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session) {
    if(!StringUtils.isEmpty(username) && "123456".equals(password)) {//登陆成功
        session.setAttribute("loginUser", username);
        //防止表单重复提交，则重定向到成功页面

        return "redirect:/succeed.html";
    }
    //登陆失败
        map.put("message", "用户名或者密码错误！");
        return "logging";
    }
}