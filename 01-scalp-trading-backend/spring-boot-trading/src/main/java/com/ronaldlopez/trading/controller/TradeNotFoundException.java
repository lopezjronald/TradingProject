package com.ronaldlopez.trading.controller;

public class TradeNotFoundException extends RuntimeException {
    TradeNotFoundException(Integer id) {
        super("Could not find employee " + id);
    }
}
