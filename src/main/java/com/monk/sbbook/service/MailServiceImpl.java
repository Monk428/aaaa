package com.monk.sbbook.service;

import com.monk.sbbook.dao.MailService;
import com.monk.sbbook.entity.Email;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;//执行者

    @Value("${spring.mail.username}")
    public String USER_NAME;//发送者

    @Override
    public void send(Email mail) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(USER_NAME);
        message.setTo(mail.getRecEmail());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送");
        } catch (Exception e) {
            logger.error("简单邮件发送失败", e);
        }
    }

    @Override
    public void sendHtml(Email email) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(USER_NAME);
            helper.setTo(email.getRecEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getContent(), true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        }
    }
}
