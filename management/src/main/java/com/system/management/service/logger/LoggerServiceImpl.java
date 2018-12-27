package com.system.management.service.logger;

import com.alibaba.fastjson.JSONObject;
import com.system.management.dao.UserSecurityMapper;
import com.system.management.model.UserSecurity;
import com.system.management.utils.Msg;
import com.system.management.utils.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 *  登陆登出注册服务
 */
public class LoggerServiceImpl implements LoggerService{
    private UserSecurityMapper userSecurityMapper;
    private HttpSession session;

    public LoggerServiceImpl(UserSecurityMapper userSecurityMapper, HttpSession session) {
        this.userSecurityMapper = userSecurityMapper;
        this.session = session;
    }

    /**
     * 登陆判定函数
     * @param msg   存放返回前端的信息
     * @param loginInfo 登陆时传入的参数
     */
    public void login(Msg msg, JSONObject loginInfo) {
        //  验证码验证
        String vCode = (String)loginInfo.get("vCode");
        String code = (String)loginInfo.get("code");
        if(!vCode.equals(code)) {
            msg.setStatus(Protocol.ERROR | Protocol.CODE);
        }

        //  账号验证
        String account = (String)loginInfo.get("account");
        String password = userSecurityMapper.getPasswordByAccount(account);
        if (password == null) {
            msg.setStatus(Protocol.INVALIATE | Protocol.ACCOUNT);
            return;
        }

        //  密码验证
        String reqPassword = (String)loginInfo.get("password");
        if (reqPassword.equals(password)) {
            msg.setStatus(Protocol.INVALIATE | Protocol.ACCOUNT);
            return;
        }

        String userNumber = userSecurityMapper.getUserNumberByAccount(account);
        session.setAttribute("userNumber", userNumber);
        msg.setStatus(Protocol.SUCCESS);
    }

    /**
     * 注册验证
     * @param msg
     * @param registerInfo
     */
    public void register(Msg msg, JSONObject registerInfo) {
        String emailCode = (String)registerInfo.get("emailCode");
        String vEmailCode = (String)registerInfo.get("vEmailCode");
        if (!emailCode.equals(vEmailCode)) {
            msg.setStatus(Protocol.CODE | Protocol.ERROR);
            return;
        }

        //  此处要抽离
        //  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String account = (String)registerInfo.get("account");
        String password = userSecurityMapper.getPasswordByAccount(account);
        if (password != null) {
            msg.setStatus(Protocol.INVALIATE | Protocol.ACCOUNT);
            return;
        }
        //  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        UserSecurity userSecurity = registerInfo.toJavaObject(UserSecurity.class);
        userSecurity.setRole("user");
        userSecurity.setStatus("useing");

        userSecurityMapper.addNewUser(userSecurity);

        msg.setStatus(Protocol.SUCCESS);
    }

}
