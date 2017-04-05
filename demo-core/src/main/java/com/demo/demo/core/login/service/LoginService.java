package com.demo.demo.core.login.service;

import com.demo.demo.core.entity.User;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.entity.UserRole;
import com.demo.demo.core.exception.EmailExistsException;
import com.demo.demo.core.repository.user.UserMailRepository;
import com.demo.demo.core.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cb on 2017/3/29.
 */
@Service
public class LoginService {
    @Autowired
    MailService mailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMailRepository userMailRepository;
    @PersistenceContext
    EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

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
        UserMail mail = userMailRepository.save(userMail);
        logger.debug("存储[user_id = {}]的邮箱[id = {}]", user.getUserId(), mail.getId());
    }







    public void test2(){
        //获取cb
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //创建查询语句
        CriteriaQuery<User> query = cb.createQuery(User.class);
        //设置查询结果
        Root<User> root = query.from(User.class);
        //查询条件
        Predicate predicate = cb.gt(root.get("userId"),1);
        //添加查询条件
        query.where(predicate);
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        List<User> result = (List<User>) typedQuery.getResultList();
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
            Predicate predicate = cb.gt(root.get("userId"),1);
            //添加查询条件
            query.where(predicate);
            TypedQuery<?> typedQuery = entityManager.createQuery(query);
            List<User> result = (List<User>) typedQuery.getResultList();
            return null;
        };
    }
}
