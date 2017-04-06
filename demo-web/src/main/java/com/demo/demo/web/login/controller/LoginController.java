package com.demo.demo.web.login.controller;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.exception.EmailParamErrorException;
import com.demo.demo.core.login.service.LoginService;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import com.demo.demo.core.user.service.RoleService;
import com.demo.demo.core.user.service.UserService;
import com.demo.demo.web.config.DemoResponse;
import com.demo.demo.web.login.vo.UserRegisterVO;
import com.demo.demo.web.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by cb on 2017/3/30.
 */
@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    /**
     * 注册功能,需要邮箱和密码
     * 先添加一个user,然后再添加一个user_mail
     * @param registerVO
     * @param br
     * @return
     */
    @PostMapping(value = "/register")
    public DemoResponse register(@Valid UserRegisterVO registerVO, BindingResult br){
        if (br.hasErrors()){
            throw new EmailParamErrorException();
        }
        //System.out.println(ConvertUtil.registerVO_UserToMail(registerVO));
        loginService.register(ConvertUtil.registerVO_UserToMail(registerVO));
        return new DemoResponse();
    }
    @GetMapping(value = "/test")
    public UserMail test(){
        return  userMailRepository.findOne(1);
    }

}
