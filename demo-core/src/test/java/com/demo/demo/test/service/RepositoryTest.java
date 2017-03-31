package com.demo.demo.test.service;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.entity.User;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.login.service.LoginService;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import com.demo.demo.core.repository.user.UserRepository;
import com.demo.demo.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

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
    @Autowired
    UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

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
        User user = new User();
        user.setUserName("tom");
        user = userRepository.save(user);
        System.out.println(user);
    }
    @Transactional
    @Test
    public void test4(){
        UserMail userMail = new UserMail();
        userMail.setMail("aaaaa@qq.com");
        userMail.setPwd("123456");
        loginService.register(userMail);
    }
    @Transactional
    @Test
    public void test5(){
        DailyReport dailyReport = new DailyReport();
        dailyReport.setId(2);
        dailyReport.setIndustry("广告");
        dailyReport = reportRepository.save(dailyReport);
        System.out.println(dailyReport);
    }
    @Transactional
    @Test
    public void test6(){
        User user = new User();
        user.setUserId(4);
        user.setName("abc");
        User user1 = entityManager.find(User.class,4);
        System.out.println(user1);
        user = entityManager.merge(user);
        System.out.println(user);

    }
}








