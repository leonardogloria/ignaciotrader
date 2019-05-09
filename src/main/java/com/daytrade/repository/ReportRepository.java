package com.daytrade.repository;

import com.daytrade.vo.ReportVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ReportRepository extends JpaRepository<ReportVO,Long> {
}
