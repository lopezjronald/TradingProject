package com.ronaldlopez.trading.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="reference_id")
    private int referenceId;

    @Column(name="trade_date")
    private String tradeDate;

    @Column(name="time_of_trade")
    private String timeOfTrade;

    @Column(name="underlying")
    private String underlying;

    @Column(name="expiration_date")
    private String expirationDate;

    @Column(name="strike_price")
    private double strikePrice;

    @Column(name="trade_type")
    private String tradeType;

    @Column(name="open_interest")
    private int openInterest;

    @Column(name="ind")
    private String ind;

    @Column(name="exchange_code")
    private String exchangeCode;

    @Column(name="spread")
    private double spread;

    @Column(name="premium_price")
    private double premiumPrice;

    @Column(name="size")
    private int size;

    @Column(name="bid_size")
    private int bidSize;

    @Column(name="bid_price")
    private double bidPrice;

    @Column(name="ask_price")
    private double askPrice;

    @Column(name="ask_size")
    private int askSize;

    @Column(name="edge")
    private String edge;

    @Column(name="lean_size")
    private int leanSize;

    @Column(name="size_ratio")
    private String sizeRatio;

    @Column(name="delta")
    private double delta;

    @Column(name="theta")
    private double theta;

    @Column(name="vega")
    private double vega;

    @Column(name="gamma")
    private double gamma;

    @Column(name="sigma")
    private double sigma;

    @Column(name="rho")
    private double rho;

}
