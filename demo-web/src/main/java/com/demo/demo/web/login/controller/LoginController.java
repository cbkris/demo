package com.demo.demo.web.login.controller;

import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.exception.DemoException;
import com.demo.demo.core.exception.EmailNotFoundException;
import com.demo.demo.core.exception.EmailParamErrorException;
import com.demo.demo.core.exception.ErrorEnum;
import com.demo.demo.core.login.constant.LoginConstants;
import com.demo.demo.core.login.service.UserService;
import com.demo.demo.core.utils.RandomStringUtil;
import com.demo.demo.web.config.DemoResponse;
import com.demo.demo.web.login.vo.UserLoginVO;
import com.demo.demo.web.login.vo.UserRegisterVO;
import com.demo.demo.web.utils.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by cb on 2017/3/30.
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RememberMeServices rememberMeServices;


    @PostMapping(value = "/login")
    public void login(@Valid UserLoginVO vo,
                      BindingResult br,
                      HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        if (br.hasErrors()) {
            throw new EmailParamErrorException();
        }
//        //已经被匿名认证过了
//        SecurityContextHolder.clearContext();
        //手动添加所需要的认证信息
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(vo.getMail(), vo.getPwd(), null);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        rememberMeServices.loginSuccess(request, response, authentication);
    }


    /**
     * 注册功能,需要邮箱和密码
     * 先添加一个user,然后再添加一个user_mail
     *
     * @param registerVO
     * @param br
     * @return
     */
    @PostMapping(value = "/register")
    public DemoResponse register(@Valid UserRegisterVO registerVO, BindingResult br, HttpSession session) {
        if (br.hasErrors()) {
            throw new EmailParamErrorException();
        }
        logger.info("用户注册[{}]",registerVO.getMail());
        //System.out.println(ConvertUtil.registerVO_UserMail(registerVO));
        UserMail userMail = userService.register(ConvertUtil.registerVO_UserMail(registerVO));
        //将用户的邮箱存入session
        session.setAttribute(LoginConstants.SESSION.EMAIL_ADDRESS, userMail.getMail());
        //将上次发送激活的时间放入session
        session.setAttribute(LoginConstants.SESSION.EMAIL_LAST_SEND_ACTIVE_TIME, new Date());
        //第一次发送激活邮件
        logger.info("向[{}]发送激活邮件",userMail.getMail());
        userService.sendActiveEmail(userMail.getMail());
        return new DemoResponse(userMail);
    }

    /**
     * 重新发送激活邮件
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/sendActive")
    public DemoResponse sendActiveEmail(HttpSession session) {
        String mail = (String) session.getAttribute(LoginConstants.SESSION.EMAIL_ADDRESS);
        //session中没有用户邮箱
        if (mail == null) {
            throw new DemoException(ErrorEnum.EMAIL_SENT_EXCEPTION.code(), ErrorEnum.EMAIL_SENT_EXCEPTION.message());
        }
        logger.info("用户[{}]请求重新发送激活邮件",mail);
        //如果有邮箱的话,需要判断发送的时间间隔
        Date last = (Date) session.getAttribute(LoginConstants.SESSION.EMAIL_LAST_SEND_ACTIVE_TIME);
        Date now = new Date();
        //如果发送时间过短,则抛出异常
        if (now.getTime()-last.getTime()< TimeUnit.SECONDS.toMillis(30)) {
            throw new DemoException(ErrorEnum.EMAIL_SENT_EXCEPTION.code(), ErrorEnum.EMAIL_SENT_EXCEPTION.message());
        }
        //这里表示时间正常,那么需要重新设置上次发送时间
        session.setAttribute(LoginConstants.SESSION.EMAIL_LAST_SEND_ACTIVE_TIME,new Date());
        userService.sendActiveEmail(mail);
        logger.info("已向[{}]发送激活邮件",mail);
        return new DemoResponse();
    }

    /**
     * 真正的激活处理,需要修改邮箱状态
     * @return
     */
    @GetMapping(value = "/active/{code}")
    public DemoResponse activeEmail(@PathVariable String code){
        return null;
    }

    @GetMapping(value = "/test")
    public DemoResponse test() {
        return new DemoResponse();
    }


}
