package com.demo.demo.core.repository.daily;

import com.demo.demo.core.entity.DailyReport;
import com.demo.demo.core.repository.BaseRepository;
import com.demo.demo.core.repository.OnlyCustomer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * Created by cb on 2017/3/28.
 */
@Repository
public interface DailyReportRepository extends BaseRepository<DailyReport,Integer>{
    //默认使用JPQL
    @Query(value = "select daily from DailyReport daily where daily.agentId=?1")
    List<DailyReport> findAllByAgentId(Integer id);

    //原生SQL语句,但是不再支持分页和排序
    @Query(nativeQuery = true,value = "SELECT * FROM daily_report daily WHERE daily.area_id=?1")
    List<DailyReport> findAllByAreaId(String areaId);
    //使用@Param指定参数
    @Query(value = "select daily from DailyReport daily where daily.operator=:operator")
    List<DailyReport> findAllByOperator(@Param("operator") String operator);
    //修改语句需要加上@Modifying注解
    @Lock(value = LockModeType.OPTIMISTIC)
    @Modifying(clearAutomatically = true)
    @Query("update DailyReport daily set daily.agent=?1 where daily.id=?2")
    int setAgentFor(String agent,Integer id);
    //仅仅暴露你想要的信息
    OnlyCustomer findById(Integer id);

}
