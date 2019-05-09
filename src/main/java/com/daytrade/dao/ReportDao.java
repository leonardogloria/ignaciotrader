package com.daytrade.dao;

import com.daytrade.repository.ReportRepository;
import com.daytrade.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportDao {
    @Autowired
    ReportRepository reportRepository;

    public void saveReport(ReportVO vo){
        reportRepository.save(vo);
    }
    public List<ReportVO> getLast(){
        return reportRepository.findAll();
    }



}
