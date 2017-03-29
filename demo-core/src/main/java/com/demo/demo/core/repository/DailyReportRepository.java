package com.demo.demo.core.repository;

import com.demo.demo.core.entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cb on 2017/3/28.
 */
@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {
}
