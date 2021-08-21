package com.citi.hackathon.PortfolioManager.services;
import com.citi.hackathon.PortfolioManager.entities.Account;
import com.citi.hackathon.PortfolioManager.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public double getStockPrice(String name) {
        try{
            double price = 0;
            Stock stock = YahooFinance.get(name);
            price = stock.getQuote().getPrice().doubleValue();
            return price;
        } catch (IOException e){
            System.out.println("Error");
        }
        return 0;
    }

    public double getHistoryPrice(String time, String ticker) {
        double prix = 0;
        //String time = "YTD";
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        //from.set(2021, 7, 12);

        switch(time){
            case "Last Week":
                from.add(Calendar.DATE, -5);
                break;
            case "Last Month":
                from.add(Calendar.MONTH, -1);
                break;
            case "Last Quarter":
                from.add(Calendar.MONTH, -3);
                break;
            case "YTD":
                from.set(2021, 0, 1);
                break;
            default:
                System.out.println("Incorrect time input");
                return prix;
        }

        try{
            Stock googleData = YahooFinance.get(ticker);
            List<HistoricalQuote> history = googleData.getHistory(from, to, Interval.DAILY);
            prix = history.get(0).getAdjClose().doubleValue();
            //System.out.println(prix + history.toString() + history.size());
        } catch (IOException e){
            System.out.println("Error");
        }

        return prix;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        Collection<Account> currAccounts = accountRepository.findAll();

        for (Account account: currAccounts){
            //System.out.println(account.getType());
            //Weird: if(account.getType()=="Investment") dont work.
            if(account.getType().length() == 10){
                account.setPrice_current(getStockPrice(account.getTicker()));
            }
        }
        //System.out.println(getHistoryPrice("YTD", "GOOG"));
        return currAccounts;
    }

    @Override
    public Collection<Account> getInvestment() {
        Collection<Account> currAccounts = accountRepository.findAll();

        Collection<Account> investments = new ArrayList<>();

        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                account.setPrice_current(getStockPrice(account.getTicker()));
                investments.add(account);
            }
        }
        return investments;
    }

    @Override
    public Collection<Account> getCash() {
        Collection<Account> currAccounts = accountRepository.findAll();

        Collection<Account> cashes = new ArrayList<>();

        for (Account account: currAccounts){
            if(account.getType().length() == 4){
                cashes.add(account);
            }
        }
        return cashes;
    }

    @Override
    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    //Initialize the value information entities.
    double cashVal = 0;
    double investVal = 0;

    @Override
    public HashMap<String, Double> getAccountValue() {
        Collection<Account> currAccounts = accountRepository.findAll();

        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                account.setPrice_current(getStockPrice(account.getTicker()));
            }
        }

        for (Account account: currAccounts){
            cashVal += account.getPrice_current();
            investVal += account.getQuantity()* account.getPrice_current();
        }

        final double netWorth = cashVal + investVal;

        HashMap<String, Double> accountVal = new HashMap<>(){{
            put("Cash Value", cashVal);
            put("Investment Value", investVal);
            put("Net Worth", netWorth);
        }};

        return accountVal;
    }

    @Override
    public Collection<String> getGainers(){
        Collection<Account> currAccounts = accountRepository.findAll();

        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                account.setPrice_current(getStockPrice(account.getTicker()));
            }
        }

        ArrayList<Account> investAcc = new ArrayList<>();
        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                investAcc.add(account);
            }
        }

        Collections.sort(investAcc, Account.lose.reversed());

        Collection<String> investGainers = new ArrayList<>();
        for(Account account: investAcc){
            if(investGainers.size() >= 5 || account.getPrice_current()- account.getPrice_purchase() < 0) break;
            else investGainers.add(account.getTicker());
        }

        return investGainers;
    }

    @Override
    public Collection<String> getLosers(){
        Collection<Account> currAccounts = accountRepository.findAll();

        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                account.setPrice_current(getStockPrice(account.getTicker()));
            }
        }

        ArrayList<Account> investAcc = new ArrayList<>();

        for (Account account: currAccounts){
            if(account.getType().length() == 10){
                investAcc.add(account);
            }
        }

        Collections.sort(investAcc, Account.lose);

        Collection<String> investLosers = new ArrayList<>();
        for(Account account: investAcc){
            if(investLosers.size() >= 5 || account.getPrice_current()- account.getPrice_purchase() > 0) break;
            else investLosers.add(account.getTicker());
        }

        return investLosers;
    }

    @Override
    public Collection<Double> getIndices() {
        Collection<Double> result = new ArrayList<>();
        String[] stickerName = {"^GSPC", "^DJI", "^IXIC", "^RUT"};

        for(String name: stickerName){
            try{
                Stock stock = YahooFinance.get(name);
                double price = stock.getQuote().getPrice().doubleValue();
                result.add(price);
            } catch (IOException e){
                System.out.println("Error");
            }
        }
        return result;
    }

    @Override
    public double getPastNetWorth(String time) {
        double networth = 0;
        Collection<Account> currAccounts = accountRepository.findAll();
        //get total cash
        for (Account account: currAccounts){
            if(account.getType().length() == 4){
                networth += account.getPrice_current();
            }
        }
        //get past total investment
        for (Account account: currAccounts) {
            if (account.getType().length() == 10) {
                networth += getHistoryPrice(time, account.getTicker());
            }
        }
        return networth;
    }
}
