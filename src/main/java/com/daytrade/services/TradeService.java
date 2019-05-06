package com.daytrade.services;

import com.daytrade.model.Investor;
import com.daytrade.model.Organization;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TradeService {
    public int ammountOfTransactions = 0;
    public List<Organization> notSelledByTurn = new ArrayList<>();


    public Set<Organization> organizationsWithoutActions = new HashSet<>();
    public Set<Investor> investorsWithoutMoney = new HashSet<>();
    public List<Organization> organizationsInGame = new ArrayList<>();
    public List<Investor> investorsInGame = new ArrayList<>();


    public List<Investor> getInvestorWithMoreActions(List<Investor> investors) {
        int moreAction = Integer.MIN_VALUE;
        List<Investor> moreInvestors = new ArrayList<>();
        Collections.sort(investors, Collections.reverseOrder());
        for (Investor i : investors) {
            if (i.getTotalNumberOfAction() >= moreAction) {
                moreInvestors.add(i);
                moreAction = i.getTotalNumberOfAction();
            }
        }
        return moreInvestors;
    }
    public List<Investor> getInvestorWithLessActions(List<Investor> investors){
        int moreAction = Integer.MAX_VALUE;
        List<Investor> moreInvestors = new ArrayList<>();
        Collections.sort(investors);
        for (Investor i : investors) {
            if (i.getTotalNumberOfAction() <= moreAction) {
                moreInvestors.add(i);
                moreAction = i.getTotalNumberOfAction();
            }
        }
        return moreInvestors;
    }

    public List<Investor> getLessDiversificated(List<Investor> investors) {
        int diversificated = Integer.MAX_VALUE;
        List<Investor> lessDiversificated = new ArrayList<>();
        Comparator<Investor> comparator = Comparator.comparing(investor -> investor.getActions().size());
        List<Investor> ordered = investors.stream().sorted(comparator).collect(Collectors.toList());

        for (Investor i : ordered) {
            if (i.getActions().size() <= diversificated) {
                lessDiversificated.add(i);
                diversificated = i.getActions().size();
            }
        }
        return lessDiversificated;
    }
    public List<Investor> getMoreDiversificated(List<Investor> investors) {
        int diversificated = Integer.MIN_VALUE;
        List<Investor> moreDiversificated = new ArrayList<>();
        Comparator<Investor> comparator = Comparator.comparing(investor -> investor.getActions().size());
        List<Investor> ordered = investors.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        for (Investor i : ordered) {
            if (i.getActions().size() >= diversificated) {
                moreDiversificated.add(i);
                diversificated = i.getActions().size();
            }
        }
        return moreDiversificated;
    }
    public List<Organization> getMostValuableOrganization(List<Organization> organizations){
        int valuable = Integer.MIN_VALUE;
        List<Organization> moreDiversificated = new ArrayList<>();


        Comparator<Organization> comparator = Comparator.comparing(organization -> organization.getCapital());
        List<Organization> ordered = organizations.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        for (Organization org : ordered) {
            if (org.getCapital() >= valuable) {
                moreDiversificated.add(org);
                valuable = org.getCapital();
            }else {
                break;
            }
        }
        return moreDiversificated;
    }
    public List<Organization> getLessValuableOrganization(List<Organization> organizations){
        int valuable = Integer.MAX_VALUE;
        List<Organization> moreDiversificated = new ArrayList<>();


        Comparator<Organization> comparator = Comparator.comparing(organization -> organization.getCapital());
        List<Organization> ordered = organizations.stream().sorted(comparator).collect(Collectors.toList());

        for (Organization org : ordered) {
            if (org.getCapital() <= valuable) {
                moreDiversificated.add(org);
                valuable = org.getCapital();
            }else {
                break;
            }
        }
        return moreDiversificated;
    }
}
