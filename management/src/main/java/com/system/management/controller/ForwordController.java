package com.system.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 相当于浏览器地址映射
 */
@Controller
public class ForwordController {
    @RequestMapping(value = "/user/login")
    public String loginView() {
        return "login";
    }
}
