package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Order;
import com.mcartagena.model.dsl.TypeOfTrade;

import java.util.function.Consumer;

public class LambdaOrderBuilder {
    private Order order = new Order();

    public static Order order(Consumer<LambdaOrderBuilder> consumer) {
        LambdaOrderBuilder builder = new LambdaOrderBuilder();
        consumer.accept(builder);
        return builder.order;
    }

    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }

    public void buy(Consumer<TradeBuilder> consumer) {
        trade(consumer, TypeOfTrade.BUY);
    }

    public void sell(Consumer<TradeBuilder> consumer) {
        trade(consumer, TypeOfTrade.SELL);
    }

    private void trade(Consumer<TradeBuilder> consumer,TypeOfTrade type) {
        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(type);
        consumer.accept(builder);
        order.addTrade(builder.trade);
    }

}
