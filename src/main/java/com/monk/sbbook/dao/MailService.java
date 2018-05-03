package com.monk.sbbook.dao;

import com.monk.sbbook.entity.Email;

public interface MailService {
//    纯文本
    void send(Email email) throws Exception;

//    富文本
    void sendHtml(Email email) throws Exception;
}
