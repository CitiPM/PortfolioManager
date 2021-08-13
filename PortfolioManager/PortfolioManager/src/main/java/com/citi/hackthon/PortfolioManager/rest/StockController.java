package com.citi.hackthon.PortfolioManager.rest;

import com.citi.hackthon.PortfolioManager.entities.Stock;
import com.citi.hackthon.PortfolioManager.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;


    @GetMapping
    public Collection<Stock> getMovies() {
        return stockService.getAllStocks();
    }
}


