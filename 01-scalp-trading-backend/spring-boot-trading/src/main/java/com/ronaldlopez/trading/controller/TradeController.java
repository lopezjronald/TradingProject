package com.ronaldlopez.trading.controller;

import com.ronaldlopez.trading.dao.TradeRepository;
import com.ronaldlopez.trading.entity.Trade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeController {

    private final TradeRepository tradeRepository;

    TradeController(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    // Aggregate root

    @GetMapping("/trades")
    List<Trade> all() {
        return tradeRepository.findAll();
    }

    @PostMapping("/trades")
    Trade newTrade(@RequestBody Trade newTrade) {
        return tradeRepository.save(newTrade);
    }

    // Single item

    @GetMapping("/trades/{id}")
    Trade one(@PathVariable Integer id) {

        return tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException(id));
    }

    @PutMapping("/trades/{id}")
    Trade replaceTrade(@RequestBody Trade newTrade, @PathVariable Integer id) {

        return tradeRepository.findById(id)
                .map(trade -> {
                    trade.setReferenceId(newTrade.getReferenceId());
                    trade.setTradeDate(newTrade.getTradeDate());
                    trade.setTimeOfTrade(newTrade.getTimeOfTrade());
                    trade.setUnderlying(newTrade.getUnderlying());
                    trade.setExpirationDate(newTrade.getExpirationDate());
                    trade.setStrikePrice(newTrade.getStrikePrice());
                    trade.setTradeType(newTrade.getTradeType());
                    trade.setOpenInterest(newTrade.getOpenInterest());
                    trade.setInd(newTrade.getInd());
                    trade.setExchangeCode(newTrade.getExchangeCode());
                    trade.setSpread(newTrade.getSpread());
                    trade.setPremiumPrice(newTrade.getPremiumPrice());
                    trade.setTradeSize(newTrade.getTradeSize());
                    trade.setBidSize(newTrade.getBidSize());
                    trade.setBidPrice(newTrade.getBidPrice());
                    trade.setAskPrice(newTrade.getAskPrice());
                    trade.setAskSize(newTrade.getAskSize());
                    trade.setEdge(newTrade.getEdge());
                    trade.setLeanSize(newTrade.getLeanSize());
                    trade.setSizeRatio(newTrade.getSizeRatio());
                    trade.setDelta(newTrade.getDelta());
                    trade.setTheta(newTrade.getTheta());
                    trade.setVega(newTrade.getVega());
                    trade.setGamma(newTrade.getGamma());
                    trade.setSigma(newTrade.getSigma());
                    trade.setRho(newTrade.getRho());
                    return tradeRepository.save(trade);
                })
                .orElseGet(() -> {
                    newTrade.setId(id);
                    return tradeRepository.save(newTrade);
                });
    }

    @DeleteMapping("/trades/{id}")
    void deleteTrade(@PathVariable Integer id) {
        tradeRepository.deleteById(id);
    }
}
