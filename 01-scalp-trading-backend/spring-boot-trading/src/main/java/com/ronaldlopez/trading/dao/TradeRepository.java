package com.ronaldlopez.trading.dao;

import com.ronaldlopez.trading.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
