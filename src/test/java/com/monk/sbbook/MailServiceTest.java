package com.monk.sbbook;

import com.monk.sbbook.entity.Email;
import com.monk.sbbook.service.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailServiceImpl mailServiceImpl;

    @Test
    public void testSimpleMail() throws Exception {
        Email email = new Email();
        email.setRecEmail("464493571@qq.com");
        email.setSubject("test simple mail");
        email.setContent("hello");
        mailServiceImpl.send(email);
    }

    @Test
    public void testHtmlMail() throws Exception {
        Email email = new Email();
        email.setRecEmail("464493571@qq.com");
        email.setSubject("test11 simple mail");
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        email.setContent(content);

        mailServiceImpl.sendHtml(email);
    }
}
