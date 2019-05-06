package com.daytrade.services;

import com.daytrade.model.Investor;
import com.daytrade.model.Organization;
import com.daytrade.model.Stock;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class BuilderService {
    public Organization generateOrganizations(Long id){
        Organization org = new Organization();
        org.setId(id);
        org.setName(String.format("Organization %s",id.toString()));

        Random r = new Random();
        org.setStocks(getRandomNumberInRange(500,1_000));
        org.setStockPrice(getRandomNumberInRange(10,101));
        org.setOriginalStockNumber(org.getStocks());
        return org;
    }
    public Investor generateInvestors(Long id){
        //here i'm using the builder pattern to maintain the facility to create new objects.
        return new Investor.Builder(id)
                .withInitialBalance(getRandomNumberInRange(1_000,10_000))
                .withName(String.format("Investor %s",id.toString()))
                .build();
    }
    public Map<Integer,Stock> generateStockPrices(){
        HashMap<Integer, Stock> stockPrices = new HashMap<>();
        IntStream.range(0,101).forEach(index -> {
            Stock stock = new Stock();
            stock.setPrice(getRandomNumberInRange(10,101));
            stockPrices.put(index,stock);
        });
        return stockPrices;

    }
    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
