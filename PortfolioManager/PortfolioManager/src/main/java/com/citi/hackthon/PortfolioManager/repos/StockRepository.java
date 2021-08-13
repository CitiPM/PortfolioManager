package com.citi.hackthon.PortfolioManager.repos;

import com.citi.hackthon.PortfolioManager.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Collection<Stock> findById(String id);
}
