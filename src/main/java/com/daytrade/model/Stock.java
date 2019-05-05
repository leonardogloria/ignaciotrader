package com.daytrade.model;

public class Stock {
    private int price;
    private int amountOfSells = 0;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountOfSells() {
        return amountOfSells;
    }

    public void setAmountOfSells(int amountOfSells) {
        this.amountOfSells = amountOfSells;
    }
}
