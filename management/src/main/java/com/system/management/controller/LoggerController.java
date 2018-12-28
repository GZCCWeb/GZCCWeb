package com.system.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.system.management.dao.UserSecurityMapper;
import com.system.management.service.logger.LoggerServiceImpl;
import com.system.management.utils.Msg;
import com.system.management.utils.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 用户登陆登出注册处理类
 */
@RequestMapping(value = "/logger")
@Controller
public class LoggerController  {
    @Autowired
    private UserSecurityMapper userSecurityMapper;
    private LoggerServiceImpl loggerService;

    /**
     * 登陆处理
     * @param loginInfo 登陆提交的json信息
     * @param session
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public Msg login(@RequestBody JSONObject loginInfo, HttpSession session) {
       loggerService = new LoggerServiceImpl(userSecurityMapper, session);
       Msg msg = new Msg();
       
       String vCode = (String)session.getAttribute("code");
       if (vCode == null) {
           msg.setStatus(Protocol.CODE | Protocol.INVALIATE);
           return msg;
       }
       loginInfo.put("vCode", vCode);
       loggerService.login(msg, loginInfo);

       return msg;
    }

    /**
     * 注册处理
     * @param registerInfo
     * @param session
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public Msg register(@RequestBody JSONObject registerInfo, HttpSession session) {
        loggerService = new LoggerServiceImpl(userSecurityMapper, session);
        Msg msg = new Msg();

        String vEmailCode = (String)session.getAttribute("vEmailCode");
        if (vEmailCode == null) {
            msg.setStatus(Protocol.CODE | Protocol.INVALIATE);
            return msg;
        }
        registerInfo.put("vEmailCode", vEmailCode);

        loggerService.register(msg, registerInfo);
        return msg;
    }
}
