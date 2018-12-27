package com.system.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 相当于浏览器地址映射
 */
@Controller
public class ForwordController {
    /**
     * 找不到页面错误
     * @return
     */
    @RequestMapping("/404Page")
    public String error404() {
        return "errorPage/404";
    }

    /**
     * 服务器内部错误
     * @return
     */
    @RequestMapping("/500Page")
    public String error500() {
        return "errorPage/500";
    }

    /**
     * 请求权限不足
     * @return
     */
    @RequestMapping("/403Page")
    public String error403() {
        return "errorPage/403";
    }

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping("/loginPage")
    public String login() {
        return "loggerPage/login";
    }

    @RequestMapping("/registerPage")
    public String register() {
        return "loggerPage/register";
    }

    @RequestMapping("/lockPage")
    public String lock() {
        return "loggerPage/lock";
    }
}
