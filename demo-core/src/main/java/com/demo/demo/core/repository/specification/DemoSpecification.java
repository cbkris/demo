package com.demo.demo.core.repository.specification;

import com.demo.demo.core.entity.*;
import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cb on 2017/4/5.
 */
public class DemoSpecification {

    public static  Specification<DailyReport> TEST1 =
            (Root<DailyReport> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
                Predicate p1 = builder.ge(root.get(DailyReport_.id),2);
                Predicate p2 = builder.lt(root.get(DailyReport_.agentId),1);
                query.where(builder.and(p1,p2.not()));
                query.orderBy(builder.desc(root.get(DailyReport_.areaId)));
                return query.getRestriction();
            };
    public static Specification<UserMail> TEST2 =
            (Root<UserMail> root,CriteriaQuery<?> query,CriteriaBuilder builder)->{
                List<Predicate> predicates = new ArrayList<>();
                Join<UserMail,User> join1 = root.join(UserMail_.user,JoinType.LEFT);
                Predicate p1 = builder.equal(join1.get(User_.userId),root.get(UserMail_.userId));
                Subquery<UserRole> subquery = query.subquery(UserRole.class);
                query.where(p1);
                return query.getRestriction();
            };
}
