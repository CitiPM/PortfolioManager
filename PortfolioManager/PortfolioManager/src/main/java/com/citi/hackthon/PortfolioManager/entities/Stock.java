package com.citi.hackthon.PortfolioManager.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="stocks")
public class Stock implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ticker_name")
    private String ticker_name;

    @Column(name="share_num")
    private int share_number;

    @Column(name="price_purchase")
    private double price_purchase;

    @Column(name="time_purchase")
    private Date time_purchase;

    @Column(name="price_sell")
    private double price_sell;

    @Column(name="time_sell")
    private Date time_sell;

    public Stock() {
    }

    public Stock(int id, String ticker_name, int share_number, double price_purchase, Date time_purchase) {
        this.id = id;
        this.ticker_name = ticker_name;
        this.share_number = share_number;
        this.price_purchase = price_purchase;
        this.time_purchase = time_purchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker_name() {
        return ticker_name;
    }

    public void setTicker_name(String ticker_name) {
        this.ticker_name = ticker_name;
    }

    public int getShare_number() {
        return share_number;
    }

    public void setShare_number(int share_number) {
        this.share_number = share_number;
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

    public double getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(double price_sell) {
        this.price_sell = price_sell;
    }

    public Date getTime_sell() {
        return time_sell;
    }

    public void setTime_sell(Date time_sell) {
        this.time_sell = time_sell;
    }
}
