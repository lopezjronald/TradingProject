package com.ronaldlopez.trading.dao;

import com.ronaldlopez.trading.entity.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    Page<Trade> findAllByExchangeCodeContaining(@RequestParam("exchangeCode") String exchangeCode, Pageable pageable);

    Page<Trade> findByReferenceId(@RequestParam("referenceId") Integer referenceId, Pageable pageable);

    Page<Trade> findAllByUnderlyingContaining(@RequestParam("underlying") String underlying, Pageable pageable);

    Page<Trade> findById(@RequestParam("id") Integer id, Pageable pageable);

}
