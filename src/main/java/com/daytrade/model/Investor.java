package com.daytrade.model;

import com.daytrade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Investor implements Comparable <Investor > {
    private Long id;
    private String name;
    private int money;
    private Map<Long,Integer> actions =  new HashMap<Long,Integer>();
    private Integer totalNumberOfAction = 0;
    public Long getId() {
        return id;
    }

    public static class Builder {
        private long id;
        private int money;
        private String name;

        public Builder(Long id){
            this.id = id;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withInitialBalance(int money){
            this.money = money;
            return this;
        }
        public Investor build(){
            return new Investor(this);
        }

    }

    private Investor(Builder builder){
        this.money = builder.money;
        this.id = builder.id;
        this.name = builder.name;
    }

    @Autowired
    TradeService tradeService;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void buyAction(Organization org, int price ){
        this.money = this.money - price;

        if(this.actions.containsKey(org.getId())){
            int amountOfActions = this.actions.get(org.getId());
            this.actions.replace(org.getId(), amountOfActions + 1);
        }else {
            this.actions.put(org.getId(), 1);
        }
    }

    public Map<Long, Integer> getActions() {
        return actions;
    }
    public void plusAction(){
        this.totalNumberOfAction++;
    }

    public Integer getTotalNumberOfAction() {
        return totalNumberOfAction;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", totalNumberOfAction=" + totalNumberOfAction +
                '}';
    }

    @Override
    public int compareTo(Investor o) {
        return this.totalNumberOfAction.compareTo(o.totalNumberOfAction);
    }
}
