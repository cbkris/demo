package com.demo.demo.core.daily.service;

import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
