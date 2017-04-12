package com.demo.demo.core.login.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Created by cb on 2017/4/11.
 */
@Component
public class MyMailSender  {
    JavaMailSenderImpl javaMailSender;
    public MyMailSender(){
        this.javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.sina.com");
        javaMailSender.setUsername("cb_kris@sina.com");
        javaMailSender.setPassword("jianshen1234");
    }
}
