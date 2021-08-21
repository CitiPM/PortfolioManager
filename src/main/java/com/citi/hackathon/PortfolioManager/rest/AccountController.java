package com.citi.hackathon.PortfolioManager.rest;

import com.citi.hackathon.PortfolioManager.entities.Account;
import com.citi.hackathon.PortfolioManager.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;


@EnableAutoConfiguration
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public Collection<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/investment")
    public Collection<Account> getInvestment() {
        return accountService.getInvestment();
    }

    @GetMapping("/cash")
    public Collection<Account> getCash() {
        return accountService.getCash();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Integer id) {
        Optional<Account> account = accountService.getAccountById(id);
        if(account.isPresent()){
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        } else {
            //TODO
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/value")
    public HashMap<String, Double> getValuesInformation() {
        //HashMap<String, Double> valInfo = accountService.getAccountValue();
        //return new String("Net Worth" + String.valueOf(valInfo.get("Net Worth")));
        return accountService.getAccountValue();
    }

    @GetMapping("/gainers")
    public Collection<String> getGainers() {
        return accountService.getGainers();
    }

    @GetMapping("/losers")
    public Collection<String> getLosers() {
        return accountService.getLosers();
    }

    @GetMapping("/indices")
    public Collection<Double> getIndices() {
        return accountService.getIndices();
    }

    @GetMapping("/past/{time}")
    public double getPastNetWorth(@PathVariable("time") String time) {
        double pastNetWorth = accountService.getPastNetWorth(time);
        return pastNetWorth;
    }

}


