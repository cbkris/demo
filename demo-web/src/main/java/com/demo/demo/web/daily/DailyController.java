package com.demo.demo.web.daily;

import com.demo.demo.core.daily.service.DailyService;
import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.entity.UserMail;
import com.demo.demo.core.login.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cb on 2017/3/28.
 */
@RestController
@RequestMapping("/daily")
public class DailyController {
    @Autowired
    DailyService dailyService;
    @Autowired
    TestService testService;

    @RequestMapping("/find")
    public DailyReport find(@RequestParam("id") DailyReport dailyReport){
        return dailyReport;
    }

    @RequestMapping("/findAll")
    public Page<DailyReport> findAll(){
        return dailyService.findAll();
    }

    @RequestMapping("/test")
    public List<UserMail> test(){
        return testService.test4();
    }
}
