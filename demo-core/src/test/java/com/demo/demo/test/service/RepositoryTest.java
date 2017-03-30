package com.demo.demo.test.service;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.login.service.LoginService;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import com.demo.demo.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cb on 2017/3/29.
 */
public class RepositoryTest extends BaseTest{
    @Autowired
    DailyReportRepository reportRepository;
    @Autowired
    DailyService service;
    @Autowired
    LoginService loginService;

    @Test
    public void test1(){
        System.out.println(service.findOne(1));
    }
    @Test
    public void test2(){
        System.out.println(service.findByExample());
    }
    @Transactional
    @Test
    public void test3(){
        UserMail userMail = new UserMail();
        userMail.setMail("aaaaa@qq.com");
        userMail.setPwd("123456");
        loginService.register(userMail);
    }
}








