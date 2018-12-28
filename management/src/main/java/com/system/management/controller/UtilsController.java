package com.system.management.controller;

import com.system.management.utils.CreateImageCode;
import com.system.management.utils.Msg;
import com.system.management.utils.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/utils")
public class UtilsController {
    /**
     * 验证码
     * @param req
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/codeImg")
    public void getCode(HttpServletRequest req, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        CreateImageCode vCode = new CreateImageCode(100,30,5,10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    @Autowired
    private JavaMailSender mailSender;
    @GetMapping("/sendCodeToEmail")
    @ResponseBody
    public Msg sendEmail(String email, HttpSession session) {
        MimeMessage message = mailSender.createMimeMessage();
        Msg msg = new Msg();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("2192301902@qq.com");
            helper.setTo(email);
            helper.setSubject("主题：邮件验证");
            CreateImageCode vCode = new CreateImageCode(100, 30, 5, 10);
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>验证码-h1</h1>")
                    .append("<p>您在我们租房系统上注册了一个新账号，如果这不是您的行为，您不必理会，注册码为:</p>")
                    .append("<p style='color:#F00'>" + vCode.getCode() + "</p>");
            helper.setText(sb.toString(), true);
            mailSender.send(message);
            session.setAttribute("vEmailCode",vCode.getCode());
        } catch (MessagingException e) {
            msg.setStatus(Protocol.ERROR | Protocol.CODE);
            e.printStackTrace();
        }

        msg.setStatus(Protocol.SUCCESS);
        return msg;
    }
}
