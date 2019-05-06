package com.daytrade.vo;

public class ReportVO {
    String mostValuable;
    String lessValuable;
    String mostDiversificated;
    String lessDiversificated;
    String mostActionNumber;
    String lessActionNumber;
    int numberOfTransactions;

    public String getMostValuable() {
        return mostValuable;
    }

    public void setMostValuable(String mostValuable) {
        this.mostValuable = mostValuable;
    }

    public String getLessValuable() {
        return lessValuable;
    }

    public void setLessValuable(String lessValuable) {
        this.lessValuable = lessValuable;
    }

    public String getMostDiversificated() {
        return mostDiversificated;
    }

    public void setMostDiversificated(String mostDiversificated) {
        this.mostDiversificated = mostDiversificated;
    }

    public String getLessDiversificated() {
        return lessDiversificated;
    }

    public void setLessDiversificated(String lessDiversificated) {
        this.lessDiversificated = lessDiversificated;
    }

    public String getMostActionNumber() {
        return mostActionNumber;
    }

    public void setMostActionNumber(String mostActionNumber) {
        this.mostActionNumber = mostActionNumber;
    }

    public String getLessActionNumber() {
        return lessActionNumber;
    }

    public void setLessActionNumber(String lessActionNumber) {
        this.lessActionNumber = lessActionNumber;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }
}
