package com.citi.hackathon.PortfolioManager.entities;
import yahoofinance.YahooFinance;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;

@Entity
@Table(name="accounts")
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    @Column(name="ticker")
    private String ticker;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price_purchase")
    private double price_purchase;

    @Column(name="time_purchase")
    private Date time_purchase;

    @Column(name="price_current")
    private double price_current;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice_purchase() {
        return price_purchase;
    }

    public void setPrice_purchase(double price_purchase) {
        this.price_purchase = price_purchase;
    }

    public Date getTime_purchase() {
        return time_purchase;
    }

    public void setTime_purchase(Date time_purchase) {
        this.time_purchase = time_purchase;
    }

    public double getPrice_current() {
        return price_current;
    }

    public void setPrice_current(double price_current) {
        this.price_current = price_current;
    }

    public static Comparator<Account> lose = (acc1, acc2) -> (int) ((acc1.getPrice_current()- acc1.getPrice_purchase())*acc1.getQuantity()
            -(acc2.getPrice_current()- acc2.getPrice_purchase())* acc2.getQuantity());

}
