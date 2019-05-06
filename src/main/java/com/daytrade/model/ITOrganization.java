package com.daytrade.model;

public class ITOrganization implements GeneralOrganization {
    private long id;
    private String name;
    private int stocks;
    private int amountOfSells = 0;

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
                ", stocks=" + stocks +
                '}';
    }
}
