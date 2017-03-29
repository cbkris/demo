package com.demo.demo.core.daily.service;

import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
