package com.citi.hackathon.PortfolioManager.repos;
import com.citi.hackathon.PortfolioManager.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
