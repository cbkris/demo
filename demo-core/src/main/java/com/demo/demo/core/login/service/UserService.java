package com.demo.demo.core.login.service;

import com.demo.demo.core.entity.User;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.exception.EmailExistsException;
import com.demo.demo.core.exception.EmailNotFoundException;
import com.demo.demo.core.exception.PasswordWrongException;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import com.demo.demo.core.utils.PwdEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cb on 2017/4/1.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;

    public UserMail findByMail(String mail){
        UserMail userMail = userMailRepository.findByMail(mail);
        return userMail;
    }

    /**
     * 用户通过邮箱登录
     * @param mail
     * @param rawPassword
     * @return
     */
    @Transactional(readOnly = true)
    public UserMail loginByMail(String mail,String rawPassword){
        logger.debug("用户[{}]登录",mail);
        UserMail userMail = userMailRepository.findByMail(mail);
        if (userMail == null) {
            throw new EmailNotFoundException();
        }
        //验证密码
        String salt = userMail.getSalt();
        logger.debug("数据库中的salt为:{}",salt);
        String password = PwdEncoder.encode(rawPassword,salt);
        logger.debug("加密后的密码为:{}",password);
        if (!password.equals(userMail.getPwd())){
            logger.warn("用户邮箱[{}]的密码{}不匹配",mail,rawPassword);
            throw new PasswordWrongException();
        }
        return userMail;
    }
    /**
     * 邮箱注册用户
     * 先注册一个空的user,把user_name设置成邮箱,拿到user_id,然后再把这个一起存到user_mail
     */
    @Transactional(readOnly = false, rollbackFor = Throwable.class)
    public void register(UserMail userMail) {
        //验证邮箱是否存在
        UserMail exists = userMailRepository.findByMail(userMail.getMail());
        if (null != exists) {
            throw new EmailExistsException();
        }
        User user = new User();
        user.setUserName(userMail.getMail());
        //将邮箱设置为用户名,并插入新用户
        user = userRepository.save(user);
        logger.info("注册新用户[user_id = {}]", user.getUserId());
        //将新用户的userId赋值给邮箱,用来插入新邮箱记录
        userMail.setUserId(user.getUserId());
        //生成一个salt
        String salt = PwdEncoder.genSalt();
        userMail.setSalt(salt);
        //将密码加密
        String password = PwdEncoder.encode(userMail.getPwd(),salt);
        userMail.setPwd(password);
        //注册新的用户
        UserMail mail = userMailRepository.save(userMail);
        logger.debug("注册用户[user_id = {}]的邮箱[id = {}]", user.getUserId(), mail.getId());
    }





    public String test(){
        return PwdEncoder.genSalt();
    }

}
