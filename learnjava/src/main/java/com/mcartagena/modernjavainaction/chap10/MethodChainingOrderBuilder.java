package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Order;
import com.mcartagena.model.dsl.Trade;
import com.mcartagena.model.dsl.TypeOfTrade;

public class MethodChainingOrderBuilder {

    public final Order order = new Order();

    private MethodChainingOrderBuilder(String customer) {
        order.setCustomer(customer);
    }

    public static MethodChainingOrderBuilder forCustomer(String customer) {
        return new MethodChainingOrderBuilder(customer);
    }

    public Order end() {
        return order;
    }

    public TradeBuilder buy(int quantity) {
        return new TradeBuilder(this, TypeOfTrade.BUY, quantity);
    }

    public TradeBuilder sell(int quantity) {
        return new TradeBuilder(this, TypeOfTrade.SELL, quantity);
    }

    protected MethodChainingOrderBuilder addTrade(Trade trade) {
        order.addTrade(trade);
        return this;
    }

}
