package com.citi.hackathon.PortfolioManager.services;
import com.citi.hackathon.PortfolioManager.entities.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface AccountService {
    Collection<Account> getAllAccounts();
    Collection<Account> getInvestment();
    Collection<Account> getCash();
    Optional<Account> getAccountById(Integer id);
    HashMap<String, Double> getAccountValue();
    double getStockPrice(String name);
    Collection<String> getGainers();
    Collection<String> getLosers();
    Collection<Double> getIndices();
    double getPastNetWorth(String time);
}

