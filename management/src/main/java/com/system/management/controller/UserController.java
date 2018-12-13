package com.system.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.management.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @PostMapping(value = "/user/loginService")
    @ResponseBody
    public Map login(@RequestBody User user) {
        JSONObject returnMsg = new JSONObject();
        returnMsg.put("user",user.getAccount());
        return returnMsg;
    }
}
