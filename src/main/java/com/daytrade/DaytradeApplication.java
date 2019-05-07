package com.daytrade;


import com.daytrade.model.Investor;
import com.daytrade.model.Organization;
import com.daytrade.model.Stock;
import com.daytrade.report.Report;
import com.daytrade.report.ReportFactory;
import com.daytrade.report.ReportType;
import com.daytrade.services.BuilderService;
import com.daytrade.services.TradeService;
import com.daytrade.vo.ReportVO;
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
        System.out.println("Creating the Sellers and Investors");

        List<Investor> investors = new ArrayList<>();
        List<Organization> organizations = new ArrayList<>();
        Map<Integer, Stock> stockPrices = new HashMap<>();

        IntStream.range(1, 101).forEach(
                index -> {
                    investors.add(this.builderServiceService.generateInvestors((long) index));
                    organizations.add(this.builderServiceService.generateOrganizations((long) index));
                }
        );
        System.out.println("Running day trade, waiting!");
        int j = 0;
        external:
        while (true)  {
                int i = new Random().nextInt((99 ) + 1);
                this.tradeService.ammountOfTransactions++;
                int org1 = new Random().nextInt((99) +1);
                int money = investors.get(i).getMoney();

                if (money >=  organizations.get(org1).getStockPrice() && organizations.get(org1).getStocks() > 0 ) {
                    investors.get(i).buyAction(organizations.get(org1), organizations.get(org1).getStockPrice());
                    investors.get(i).plusAction();
                    organizations.get(org1).sellAction();
                    this.tradeService.notSelledByTurn.remove(organizations.get(org1));

                    if(investors.get(i).getMoney() <= 0){
                        this.tradeService.investorsWithoutMoney.add(investors.get(i));
                    }
                    if(organizations.get(org1).getStocks() <= 0) {
                        this.tradeService.organizationsWithoutActions.add(organizations.get(org1));
                    }
                    if(organizations.get(org1).getAmountOfSells() == 10){
                        organizations.get(org1).setStockPrice(organizations.get(org1).getStockPrice() * 2);
                        organizations.get(org1).setAmountOfSells(0);
                    }
                    if(this.tradeService.ammountOfTransactions % 10 == 0){
                        for(Organization organization : this.tradeService.notSelledByTurn) {
                            int organizationId = (int) organization.getId();
                            int decrement = (int)(organization.getStockPrice() * 0.2);
                            organization.setStockPrice(organization.getStockPrice() - decrement);

                        }
                        this.tradeService.notSelledByTurn = new ArrayList<>();
                        for(int organizationId = 0; organizationId<100;organizationId++) {
                            this.tradeService.notSelledByTurn.add(organizations.get(organizationId));
                        }
                    }
                }
                if(this.tradeService.investorsWithoutMoney.size() >= 100){
                    break external;
                }
                if(this.tradeService.organizationsWithoutActions.size() >= 100){
                    break external;
                }

            j++;
    }

     menu(investors,organizations);






    }
    private void menu(List<Investor> investors, List<Organization> organizations){
        int option = 0;
        do {
            System.out.println("\n\n           ###            Welcome to Day Trade Simulator         ###");
            System.out.println("\n                  =============================================");
            System.out.println("                  |     1 - Investor with more Actions         |");
            System.out.println("                  |     2 - Investor with less Actions         |");
            System.out.println("                  |     3 - More Diversificated Investor       |");
            System.out.println("                  |     4 - Less Diversificated Investor       |");
            System.out.println("                  |     5 - Most Valuable Organization         |");
            System.out.println("                  |     6 - Less Valuable Organization         |");
            System.out.println("                  |     7 - Number os Transactions             |");
            System.out.println("                  |     8 - Export Results  to CSV             |");
            System.out.println("                  |     0 - Exit                               |");
            System.out.println("                  ================================================\n");
            Scanner scanner = new Scanner(System.in);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        List<Investor> biggest = tradeService.getInvestorWithMoreActions(investors);
                        biggest.forEach(System.out::println);
                        break;
                    case 2:
                        List<Investor> min = tradeService.getInvestorWithLessActions(investors);
                        min.forEach(System.out::println);
                        break;
                    case 3:
                        List<Investor> moreDiversificated = tradeService.getMoreDiversificated(investors);
                        moreDiversificated.forEach(System.out::println);
                        break;
                    case 4:
                        List<Investor> lessDiversificated = tradeService.getLessDiversificated(investors);
                        lessDiversificated.forEach(System.out::println);
                        break;
                    case 5:
                        List<Organization> moreValuable = tradeService.getMostValuableOrganization(organizations);
                        moreValuable.forEach(System.out::println);
                        break;
                    case 6:
                        List<Organization> lessValuable = tradeService.getLessValuableOrganization(organizations);
                        lessValuable.forEach(System.out::println);
                        break;
                    case 7:
                        System.out.println(tradeService.ammountOfTransactions);
                    case 8:
                        ReportVO vo = new ReportVO();
                        String moreActions = tradeService.getInvestorWithMoreActions(investors).get(0).getName();
                        String minActions = tradeService.getInvestorWithLessActions(investors).get(0).getName();
                        String maxDiversificated = tradeService.getMoreDiversificated(investors).get(0).getName();
                        String minDiversificated = tradeService.getLessDiversificated(investors).get(0).getName();
                        String  mostValuable = tradeService.getMostValuableOrganization(organizations).get(0)
                                .getName();
                        String  minValuable = tradeService.getLessValuableOrganization(organizations).get(0)
                                .getName();


                        vo.setMostActionNumber(moreActions);
                        vo.setMostDiversificated(maxDiversificated);
                        vo.setMostValuable(mostValuable);
                        vo.setLessActionNumber(minActions);
                        vo.setLessDiversificated(minDiversificated);
                        vo.setLessValuable(minValuable);
                        vo.setNumberOfTransactions(tradeService.ammountOfTransactions);
                        Report report = new ReportFactory().getReport(ReportType.CSV);
                        report.writeReport(vo);

                    case 0:
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                }

            }catch (InputMismatchException ie){
                System.out.println("Invalid Option");
                option = -1;
            }
        }while (option != 0) ;

    }
	public static void main(String[] args) {

		SpringApplication.run(DaytradeApplication.class, args);
	}

}
