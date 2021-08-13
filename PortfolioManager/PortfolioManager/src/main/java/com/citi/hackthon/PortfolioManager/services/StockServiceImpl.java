package com.citi.hackthon.PortfolioManager.services;
import com.citi.hackthon.PortfolioManager.entities.Stock;
import com.citi.hackthon.PortfolioManager.repos.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Collection<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}
