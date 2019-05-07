package com.daytrade.report;

import com.daytrade.vo.ReportVO;

public class EnhancedCSVReport extends ReportDecorator {
    public EnhancedCSVReport(Report report) {
        super(report);
    }

    @Override
    public void writeReport(ReportVO vo) {
        super.writeReport(vo);
        /*
            I'm using the decorator pattern to extends the cvs report functionality by sending email to mangers after
            the report has been generated.
         */
        sendMailToManagers();

    }
    private void sendMailToManagers(){
        System.out.println("Sending mail to managers");

    }
}
