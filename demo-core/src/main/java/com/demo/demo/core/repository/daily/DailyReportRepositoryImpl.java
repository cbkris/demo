package com.demo.demo.core.repository.daily;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by cb on 2017/4/12.
 */
@Repository
public class DailyReportRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;



}
