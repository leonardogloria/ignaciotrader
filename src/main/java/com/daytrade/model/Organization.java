package com.daytrade.model;

import com.daytrade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class Organization {
    private long id;
    private String name;
    private int stocks;
    private int originalStockNumber;
    private int amountOfSells = 0;
    private int capital;
    private int stockPrice;

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.capital = originalStockNumber * stockPrice;
        this.stockPrice = stockPrice;
    }

    public int getAmountOfSells() {
        return amountOfSells;
    }

    public void setAmountOfSells(int amountOfSells) {
        this.amountOfSells = amountOfSells;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStocks() {
        return stocks;
    }

    public int getOriginalStockNumber() {
        return originalStockNumber;
    }

    public void setOriginalStockNumber(int originalStockNumber) {
        this.originalStockNumber = originalStockNumber;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
    public void sellAction(){
        this.stocks--;
        this.amountOfSells++;

    }
    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stocks=" + originalStockNumber + '\'' +
                ", stockPrice =" + getStockPrice() + '\'' +
                ", capital =" + getCapital()  +
                '}';
    }



    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
