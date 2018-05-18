package com.monk.sbbook.service;

import com.monk.sbbook.entity.Email;

/**
 * 邮件发送接口
 */
public interface MailService {
//    纯文本
    void send(Email email) throws Exception;

//    富文本
    void sendHtml(Email email) throws Exception;

//    freemaker模板
}
