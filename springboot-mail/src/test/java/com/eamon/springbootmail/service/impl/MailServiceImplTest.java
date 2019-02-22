package com.eamon.springbootmail.service.impl;

import com.eamon.springbootmail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: eamon
 * @date: 2019-02-22 16:44
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceImplTest {

    @Autowired
    MailService mailService;

    @Test
    public void testSendMail(){
        mailService.sendSimpleMail("chasen.xie@trustasia.com","test simple mail","Hello this is a simple mail");
    }

}