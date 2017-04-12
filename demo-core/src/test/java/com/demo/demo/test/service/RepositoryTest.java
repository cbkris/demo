package com.demo.demo.test.service;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.entity.*;
import com.demo.demo.core.login.service.MailService;
import com.demo.demo.core.login.service.TestService;
import com.demo.demo.core.login.service.UserService;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import com.demo.demo.core.repository.user.PermissionRepository;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import com.demo.demo.test.BaseTest;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by cb on 2017/3/29.
 */
public class RepositoryTest extends BaseTest{

    @PersistenceContext(unitName = "main")
    EntityManager entityManager;
    @Autowired
    DailyReportRepository reportRepository;
    @Autowired
    DailyService service;
    @Autowired
    TestService testService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    MailService mailService;
    @Autowired
    UserService userService;

    /**
     * 邮件测试
     */
    @Test
    public void test11(){
        mailService.sendTest("975677342@qq.com","Hello","World");
    }


    @Test
    public void test10(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(2,2,sort);
        Integer pageSize = pageable.getPageSize();
        Integer pageNo = pageable.getPageNumber();
        pageable.first();
        pageable.next();
        pageable.previousOrFirst();
        Slice<DailyReport> pageResult = reportRepository.findAll(pageable.first());
        System.out.println(pageResult.getContent());
    }

    @Test
    public void test9(){
        System.out.println(userMailRepository.findByMail("975677342@qq.com"));
    }

    @Test
    public void test8(){
        System.out.println(userRepository.findOne(4));
    }

    @Test
    public void test7(){
        testService.test2();
    }

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
        //loginService.register(userMail);
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








