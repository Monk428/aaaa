package com.monk.sbbook.service;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Component
public class MailServiceImpl {
    private String host = "smtp.126.com";
    private String user = "wengjianfen@126.com";
    private String pwd = "Wengjianfeng";

    private String from = "";
    private String to = "";
    private String subject = "";

    public void setAddress(String from, String to, String subject) {
        this.from = from;
        this.to = to;
        this.subject = subject;

    }

    public void send(String txt) throws AddressException, MessagingException {
        Properties props = new Properties();
        //MailAuthenticator auth = new MailAuthenticator(user, pwd);

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);

        Multipart multipart = new MimeMultipart();
        BodyPart contentPart = new MimeBodyPart();
        //contentPart.setText(txt);
        /*设置文本格式，使其接受http格式的链接*/
        contentPart.setContent(txt,"text/html; charset=utf-8");
        multipart.addBodyPart(contentPart);

        //BodyPart messageBodyPart = new MimeBodyPart();
        //DataSource source = new FileDataSource(affix);
        //messageBodyPart.setDataHandler(new DataHandler(source));

        sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
        //messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(affixName.getBytes()) + "?=");   //
        //multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);
        Transport transport = session.getTransport("smtp");
        transport.connect(host, user, pwd);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();



    }

    public static void main(String[] args) {
        //	private String host = "smtp.163.com";
//	private String user = "igoqhb@163.com";
//	private String pwd = "qihongbo1990";
        SendMail cn = new SendMail();
        cn.setAddress("igoqhb@163.com", "2807154372@qq.com", "激活");
//		cn.setAddress("igoqhb@163.com", "2807154372@qq.com", "激活");
        //while(true)
        try {
            cn.send("点击下面的链接激活！<a href='http://localhost:8080/post.html?username=jackey&password=hello'>点击此链接</a>");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //cn.send("QQ:" + args[0] + "\tPWD:" + args[1]);
    }
}
