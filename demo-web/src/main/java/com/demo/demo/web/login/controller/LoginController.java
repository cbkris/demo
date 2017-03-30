package com.demo.demo.web.login.controller;

import com.demo.demo.core.exception.EmailParamErrorException;
import com.demo.demo.core.login.service.LoginService;
import com.demo.demo.web.config.DemoResponse;
import com.demo.demo.web.login.vo.UserRegisterVO;
import com.demo.demo.web.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cb on 2017/3/30.
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;



    /**
     * 注册功能,需要邮箱和密码
     * 先添加一个user,然后再添加一个user_mail
     * @param registerVO
     * @param br
     * @return
     */
    @PostMapping(value = "/register")
    public DemoResponse register(UserRegisterVO registerVO, BindingResult br){
        if (br.hasErrors()){
            throw new EmailParamErrorException();
        }
        loginService.register(ConvertUtil.registerVO_UserToMail(registerVO));
        return new DemoResponse();
    }
}
