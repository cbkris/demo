package com.demo.demo.core.repository.daily;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by cb on 2017/3/29.
 * 中间接口,不希望创建Bean
 */
@NoRepositoryBean
public interface DemoRepository<T,ID extends Serializable> extends Repository<T, ID> ,QueryDslPredicateExecutor{

}
