package com.citi.hackthon.PortfolioManager.services;

import com.citi.hackthon.PortfolioManager.entities.Stock;

import java.util.Collection;

public interface StockService {
    Collection<Stock> getAllStocks();
}

