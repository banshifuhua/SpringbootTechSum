package com.eamon.springbootmail.service;

/**
 * @author: eamon
 * @date: 2019-02-22 16:40
 * @description:
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
