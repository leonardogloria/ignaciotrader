package com.daytrade.report;

import com.daytrade.model.Investor;
import com.daytrade.services.TradeService;
import com.daytrade.vo.ReportVO;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CsvReport implements Report {

    @Override
    public void writeReport(ReportVO vo) {
        File file = new File("report/trade.csv");
        try{
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = { "Date Time", "Most Diversificated", "Less Diversificated", "Max Action number", "Min Action number",
            "Most Valuable", "Less Valuable", "Number of Transactions"};
            writer.writeNext(header);
            String[] data1 = { new Date().toString(), vo.getMostDiversificated() , vo.getLessDiversificated(),
                    vo.getMostActionNumber(), vo.getLessActionNumber(),vo.getMostValuable(), vo.getLessValuable(),
                    Integer.toString(vo.getNumberOfTransactions())  };
            writer.writeNext(data1);
            writer.close();
        }catch (IOException ex){}
    }
}
