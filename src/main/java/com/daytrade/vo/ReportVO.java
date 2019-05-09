package com.daytrade.vo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ReportVO {
    @Id @GeneratedValue
    Long id;

    String mostValuable;
    String lessValuable;
    String mostDiversificated;
    String lessDiversificated;
    String mostActionNumber;
    String lessActionNumber;
    int numberOfTransactions;
    Date dateTime;

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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ReportVO{" +
                "id=" + id +
                ", mostValuable='" + mostValuable + '\'' +
                ", lessValuable='" + lessValuable + '\'' +
                ", mostDiversificated='" + mostDiversificated + '\'' +
                ", lessDiversificated='" + lessDiversificated + '\'' +
                ", mostActionNumber='" + mostActionNumber + '\'' +
                ", lessActionNumber='" + lessActionNumber + '\'' +
                ", numberOfTransactions=" + numberOfTransactions +
                ", dateTime=" + dateTime +
                '}';
    }
}
