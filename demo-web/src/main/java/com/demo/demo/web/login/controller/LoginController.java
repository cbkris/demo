package com.demo.demo.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cb on 2017/3/23.
 */
@Controller
public class LoginController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
