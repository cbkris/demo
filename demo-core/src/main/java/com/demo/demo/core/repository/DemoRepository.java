package com.demo.demo.core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by cb on 2017/3/29.
 * 中间接口,不希望创建Bean
 */
@NoRepositoryBean
public interface DemoRepository<T,ID extends Serializable> extends Repository<T, ID>{
    //通用的查询语句
    @Query(value = "select t from #{#entityName} t where t.id=?1")
    T findById(Integer id);
}
