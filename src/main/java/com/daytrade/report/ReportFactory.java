package com.daytrade.report;

public class ReportFactory {
    public Report getReport(ReportType reportType ){
        if(reportType.equals(ReportType.CSV)){
            return new CsvReport();
        }
        return new CsvReport();
    }
}

