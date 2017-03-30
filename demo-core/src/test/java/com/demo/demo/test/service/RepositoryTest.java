package com.demo.demo.test.service;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import com.demo.demo.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cb on 2017/3/29.
 */
public class RepositoryTest extends BaseTest{
    @Autowired
    DailyReportRepository reportRepository;
    @Autowired
    DailyService service;

    @Test
    public void test1(){
        System.out.println(service.findOne(1));
    }
}
