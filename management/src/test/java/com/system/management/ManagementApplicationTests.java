package com.system.management;

import com.system.management.utils.CreateImageCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagementApplicationTests {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        String email = "784172167@qq.com";
        MimeMessage message = mailSender.createMimeMessage();


        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("2192301902@qq.com");
        helper.setTo(email);
        helper.setSubject("主题：邮件验证");
        CreateImageCode vCode = new CreateImageCode(100,30,5,10);
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>验证码-h1</h1>")
                .append("<p>您在我们租房系统上注册了一个新账号，如果这不是您的行为，您不必理会，注册码为:</p>")
                .append("<p style='color:#F00'>"+vCode.getCode()+"</p>");
        helper.setText(sb.toString(), true);
        mailSender.send(message);
    }

//    @Autowired
//    private VelocityEngine velocityEngine;
//
//    @Test
//    public void sendTemplateMail() throws Exception {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//        helper.setFrom("2192301902@vcredit.com");
//        helper.setTo("784172167@vcredit.com");
//        helper.setSubject("主题：模板邮件");
//        Map<String, Object> model = new HashedMap();
//        model.put("username", "didi");
//        String text = VelocityEngineUtils.mergeTemplateIntoString(
//                velocityEngine, "template.vm", "UTF-8", model);
//        helper.setText(text, true);
//        mailSender.send(mimeMessage);
//    }


}
