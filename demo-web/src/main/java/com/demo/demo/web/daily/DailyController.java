package com.demo.demo.web.daily;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.entity.DailyReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cb on 2017/3/28.
 */
@RestController
@RequestMapping("/daily")
public class DailyController {
    @Autowired
    DailyService dailyService;
    @RequestMapping("/find")
    public DailyReport find(@RequestParam("id") DailyReport dailyReport){
        return dailyReport;
    }

    @RequestMapping("/findAll")
    public Page<DailyReport> findAll(){
        return dailyService.findAll();
    }
}
