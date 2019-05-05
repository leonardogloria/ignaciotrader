package com.daytrade;


import com.daytrade.model.Investor;
import com.daytrade.model.Organization;
import com.daytrade.model.Stock;
import com.daytrade.services.BuilderService;
import com.daytrade.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.IntStream;

@SpringBootApplication
public class DaytradeApplication implements CommandLineRunner {
    @Autowired
    BuilderService builderServiceService;
    @Autowired
    TradeService tradeService;


    @Override
    public void run(String... args) {
        System.out.println("Ready to comply!");
        System.out.println("Creating the Sellers");
        List<Investor> investors = new ArrayList<>();
        List<Organization> organizations = new ArrayList<>();
        Map<Integer, Stock> stockPrices = new HashMap<>();

        IntStream.range(1, 101).forEach(
                index -> {
                    investors.add(this.builderServiceService.generateInvestors((long) index));
                    organizations.add(this.builderServiceService.generateOrganizations((long) index));

                }

        );
        stockPrices = this.builderServiceService.generateStockPrices();
        for(int i = 0; i<100;i++){
            this.tradeService.notSelledByTurn.add(organizations.get(i));
            System.out.println(organizations.get(i));

        }
        for (int i = 0; i < 100; i++) {
            this.tradeService.investorsInGame.add(investors.get(i));
        }
        /*
        investors.forEach(i -> System.out.println(i));
        organizations.forEach(o -> System.out.println(o));
        stockPrices.forEach((organization,stockPrice) ->{
            System.out.println(organization + " " + stockPrice);
        });
        */
        int j = 0;
        external:
        while (j < 900_000)  {
            for (int i = 0; i < 100; i++) {
                int org1 = new Random().nextInt((99 + 1));
                //System.out.println(investors.get(i).getName() + " is try to buy action from: " + organizations.get(org1).getName() + " by " +stockPrices.get(org1) );
                int money = investors.get(i).getMoney();

                if (money >= stockPrices.get(org1).getPrice() && organizations.get(org1).getStocks() > 0 ) {
                    investors.get(i).buyAction(organizations.get(org1), stockPrices.get(org1).getPrice());
                    organizations.get(org1).sellAction();
                    this.tradeService.ammountOfTransactions++;
                    this.tradeService.notSelledByTurn.remove(organizations.get(org1));


                    if(investors.get(i).getMoney() <= 0){
                        System.out.println(investors.get(i).getName() + " is out of money + \n");
                        this.tradeService.investorsWithoutMoney.add(investors.get(i));
                    }
                    if(organizations.get(org1).getStocks() <= 0) {
                        System.out.printf(organizations.get(org1).getName() + " is out of stock  \n");
                        this.tradeService.organizationsWithoutActions.add(organizations.get(org1));
                    }
                    if(organizations.get(org1).getAmountOfSells() % 10 == 0){
                        System.out.println(organizations.get(org1).getAmountOfSells());
                        System.out.println("Price of stock " + organizations.get(org1).getName() + " goes up");
                        stockPrices.get(org1).setPrice(stockPrices.get(org1).getPrice() * 2);
                    }
                    if(this.tradeService.ammountOfTransactions % 10 == 0){
                        for(Organization organization : this.tradeService.notSelledByTurn) {
                            System.out.println("Price of stock " + organization.getName() + "goes down");
                            stockPrices.get(org1).setPrice(stockPrices.get(org1).getPrice() / 2);
                            this.tradeService.notSelledByTurn = new ArrayList<>();
                            for(int organizationId = 0; i<50;i++) {
                                this.tradeService.notSelledByTurn.add(organizations.get(organizationId));
                            }



                        }



                    }

                }
                if(this.tradeService.investorsWithoutMoney.size() >= 4){
                    System.out.println("Acabou o dinheiro de todos \n");
                    break external;
                }
                if(this.tradeService.organizationsWithoutActions.size() >=6){
                    System.out.printf("Acabou a quantidade de acoes \n");
                    break external;
                }
                //System.out.println("Amount of investors without " + this.tradeService.amountOfInvestorsWithoutMoney);
                //System.out.println("Amount of organizations without " + this.tradeService.amountOfOrganizationsWithoutActions);


            }
            j++;
    }

        for(int i = 0;i<4;i++){
            System.out.println("Investor " + i + " money: " + investors.get(i).getMoney());
            investors.get(i).getActions().forEach((organization,ammount) -> {
                System.out.println(organization + " --  " + ammount);

            });

        }
        for(int i = 0; i<6;i++){
            System.out.println(organizations.get(i));

        }



    }

	public static void main(String[] args) {

		SpringApplication.run(DaytradeApplication.class, args);
	}

}
