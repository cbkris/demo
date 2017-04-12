package com.demo.demo.core.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by cb on 2017/3/30.
 * 邮件发送
 */
@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Autowired
    MyMailSender mailSender;

    /**
     * 发送邮件
     * @param target
     * @param subject
     * @param text
     */
    public void sendMail(String target, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("cb_kris@sina.com");
        simpleMailMessage.setTo(target);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        mailSender.javaMailSender.send(simpleMailMessage);
        logger.info("向[{}]发送邮件",target);
    }
}
