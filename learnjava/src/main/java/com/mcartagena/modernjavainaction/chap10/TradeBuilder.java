package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Trade;
import com.mcartagena.model.dsl.TypeOfTrade;

import java.util.function.Consumer;

public class TradeBuilder {
    private final MethodChainingOrderBuilder builder;
    public final Trade trade = new Trade();

    protected TradeBuilder(MethodChainingOrderBuilder builder, TypeOfTrade type, int quantity) {
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public TradeBuilder() {
        this.builder = null;
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }

    // lambda style
    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.getStock());
    }

    // mixed style

    public TradeBuilder quantityMixedStyle(int quantity) {
        trade.setQuantity(quantity);
        return this;
    }

    public TradeBuilder at(double price) {
        trade.setPrice(price);
        return this;
    }

    public StockBuilder stockMixedStyle(String symbol) {
        return new StockBuilder(this, trade, symbol);
    }

}
