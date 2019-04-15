package com.jj.learning.springboot.chapter27;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Chapter27ApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    freemarker.template.Configuration freemarkerConfig;

    // 純文本格式
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jj.huang@hotmail.com");
        message.setTo("jj.huang@*****.com.tw");
        message.setSubject("主旨：Hello J.J.Huang");
        message.setText("內容：這是一封測試信件，恭喜您成功發送了唷");

        mailSender.send(message);
    }

    // 夾帶附件
    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("jj.huang@hotmail.com");
        helper.setTo("jj.huang@*****.com.tw");
        helper.setSubject("主旨：Hello J.J.Huang 附上附件");
        helper.setText("內容：請檢閱附件內容");

        FileSystemResource file = new FileSystemResource(new File("hotmail.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
    }

    // 嵌入靜態資源
    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("jj.huang@hotmail.com");
        helper.setTo("jj.huang@*****.com.tw");
        helper.setSubject("主旨：Hello J.J.Huang 嵌入靜態資源");
        helper.setText("<html><body><img src=\"cid:hotmail\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("hotmail.jpg"));
        helper.addInline("hotmail", file);

        mailSender.send(mimeMessage);
    }

    // 模版信件
    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("jj.huang@hotmail.com");
        helper.setTo("jj.huang@*****.com.tw");
        helper.setSubject("主旨：Hello J.J.Huang 模版信件");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("userName", "J.J.Huang");
        String templateString = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate("template.html"), model);
        helper.setText(templateString, true);

        FileSystemResource file = new FileSystemResource(new File("QrCode.png"));
        helper.addInline("qrCode", file);

        mailSender.send(mimeMessage);
    }

}
