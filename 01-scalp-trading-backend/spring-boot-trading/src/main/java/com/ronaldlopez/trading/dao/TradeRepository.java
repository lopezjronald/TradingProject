package com.ronaldlopez.trading.dao;

import com.ronaldlopez.trading.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface TradeRepository extends JpaRepository<Trade, Integer> {

}
