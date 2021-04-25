package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Stock;
import com.mcartagena.model.dsl.Trade;

public class StockBuilder {
    private final MethodChainingOrderBuilder builder;
    private final TradeBuilder tradeBuilder;
    private final Trade trade;
    private final Stock stock = new Stock();

    protected StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
        this.tradeBuilder = null;
        this.builder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    protected StockBuilder(){
        this.tradeBuilder = null;
        this.builder = null;
        this.trade = null;
    }

    public TradeBuilderWithStock on(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return new TradeBuilderWithStock(builder, trade);
    }

    // lambda style

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }

    public Stock getStock(){
        return this.stock;
    }

    // mixed style

    protected StockBuilder(TradeBuilder builder, Trade trade, String symbol) {
        this.builder = null;
        this.tradeBuilder = builder;
        this.trade = trade;
        stock.setSymbol(symbol);
    }

    public TradeBuilder onMixStyle(String market) {
        stock.setMarket(market);
        trade.setStock(stock);
        return tradeBuilder;
    }
}
