package com.daytrade.report;

import com.daytrade.dao.ReportDao;
import com.daytrade.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;

public class H2Report implements Report {
    @Autowired
    ReportDao reportDao;
    @Override
    public void writeReport(ReportVO vo) {
        reportDao.saveReport(vo);
    }
}
