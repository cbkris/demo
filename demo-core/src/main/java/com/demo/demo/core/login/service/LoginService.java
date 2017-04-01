package com.demo.demo.core.login.service;

import com.demo.demo.core.entity.User;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by cb on 2017/3/29.
 */
@Service
public class LoginService {
    @Autowired
    MailService mailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;



    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    /**
     * 邮箱注册用户
     * 先注册一个空的user,把user_name设置成邮箱,拿到user_id,然后再把这个一起存到user_mail
     */
    @Transactional(readOnly = false, rollbackFor = Throwable.class)
    public void register(UserMail userMail) {
        User user = new User();
        user.setUserName(userMail.getMail());
        user = userRepository.save(user);
        logger.info("注册新用户[user_id = {}]", user.getUserId());
        userMail.setUserId(user.getUserId());
        UserMail mail = userMailRepository.save(userMail);
        logger.debug("存储[user_id = {}]的邮箱[id = {}]", user.getUserId(), mail.getId());
        System.out.println(mail);
    }

}
