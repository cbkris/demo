package com.demo.demo.core.user.service;

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
}
