package com.system.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 相当于浏览器地址映射
 */
@Controller
public class ForwordController {
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 500 error
     * @return
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }
}
