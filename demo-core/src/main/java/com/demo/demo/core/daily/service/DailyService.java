package com.demo.demo.core.daily.service;

import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.repository.daily.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * Created by cb on 2017/3/28.
 */
@Service
public class DailyService {
    @Autowired
    DailyReportRepository repository;

    public DailyReport findOne(Integer id){
        return repository.findOne(id);
    }

    public Page<DailyReport> findAll(){
        Pageable pageable = new PageRequest(2,2);
        Page<DailyReport> page = repository.findAll(pageable);
        return page;
    }
    //测试Example查询
    public List<DailyReport> findByExample(){
        DailyReport dailyReport = new DailyReport();
        //dailyReport.setAgentId(22);
        //dailyReport.setAreaId(3);
        ExampleMatcher matcher = ExampleMatcher.matching().withIncludeNullValues();
        Example<DailyReport> example = Example.of(dailyReport);
        List<DailyReport> reports = repository.findAll(example);
        return reports;
    }
}














