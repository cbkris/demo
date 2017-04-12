package com.demo.demo.core.login.service;

import com.demo.demo.core.entity.*;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import com.demo.demo.core.repository.specification.DemoSpecification;
import com.demo.demo.core.repository.user.UserMailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by cb on 2017/3/29.
 */
@Service
public class TestService {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    DailyReportRepository dailyReportRepository;
    @Autowired
    UserMailRepository userMailRepository;

    private static final Logger logger = LoggerFactory.getLogger(TestService.class);


    public List<UserMail> test4(){
        return userMailRepository.findAll(DemoSpecification.TEST2);
    }

    public List<DailyReport> test3(){
        return dailyReportRepository.findAll(DemoSpecification.TEST1);
    }

    public void test2(){
        //获取cb
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //创建查询语句
        CriteriaQuery<User> query = cb.createQuery(User.class);
        //设置查询结果
        Root<User> root = query.from(User.class);
        //查询条件
        Predicate predicate = cb.gt(root.get(User_.userId),1);
        //添加查询条件
        query.where(predicate);
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        List<User> result = typedQuery.getResultList();
        System.out.println(result);
    }

    public void test1() {
        Specification<User> specification = (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            //获取cb
            cb = entityManager.getCriteriaBuilder();
            //创建查询语句
            query = cb.createQuery(User.class);
            //设置查询结果
            root = query.from(User.class);
            //查询条件
            Predicate predicate = cb.gt(root.get(User_.userId),1);
            //添加查询条件
            query.where(predicate);
            TypedQuery<?> typedQuery = entityManager.createQuery(query);
            List<User> result = (List<User>) typedQuery.getResultList();
            return null;
        };
    }
}
