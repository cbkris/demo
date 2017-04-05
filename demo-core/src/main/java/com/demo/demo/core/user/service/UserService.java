package com.demo.demo.core.user.service;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cb on 2017/4/1.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;

    public UserMail findByMail(String mail){
        UserMail userMail = userMailRepository.findByMail(mail);
        return userMail;
    }
}
