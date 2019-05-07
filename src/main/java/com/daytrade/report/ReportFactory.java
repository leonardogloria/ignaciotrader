package com.daytrade.report;

/*
Here i'm using the factory pattern.
It turns easy to create news ways to generate reports like relational and non relational databases.
 */
public class ReportFactory {
    public Report getReport(ReportType reportType ){
        if(reportType.equals(ReportType.CSV)){
            return new CsvReport();
        }
        return new CsvReport();
    }
}

