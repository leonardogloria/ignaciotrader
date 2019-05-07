package com.daytrade.report;

import com.daytrade.vo.ReportVO;

public class ReportDecorator implements Report {
    protected Report report;
    public ReportDecorator(Report report){
        this.report = report;
    }

    @Override
    public void writeReport(ReportVO vo) {
        this.report.writeReport(vo);
    }
}
