package com.daytrade.model;

import com.daytrade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Investor {
    private Long id;
    private String name;
    private int money;
    private Map<Long,Integer> actions =  new HashMap<Long,Integer>();
    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
