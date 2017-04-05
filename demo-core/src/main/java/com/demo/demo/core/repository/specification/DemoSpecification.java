package com.demo.demo.core.repository.specification;

import com.demo.demo.core.entity.Permission;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by cb on 2017/4/5.
 */
public class DemoSpecification {
    public static  Specification<Permission> permission = (Root<Permission> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->{
        
        return null;
    };
}
