package com.daytrade.services;

import com.daytrade.model.Investor;
import com.daytrade.model.Organization;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TradeService {
    public int ammountOfTransactions = 0;
    public List<Organization> notSelledByTurn = new ArrayList<>();


    public Set<Organization> organizationsWithoutActions = new HashSet<>();
    public Set<Investor> investorsWithoutMoney = new HashSet<>();
    public List<Organization> organizationsInGame = new ArrayList<>();
    public List<Investor> investorsInGame = new ArrayList<>();



}
