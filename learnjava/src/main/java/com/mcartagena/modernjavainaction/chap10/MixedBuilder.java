package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Order;
import com.mcartagena.model.dsl.TypeOfTrade;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MixedBuilder {
    public static Order forCustomerMixedStyle(String customer, TradeBuilder... builders) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(builders).forEach(b -> order.addTrade(b.trade));
        return order;
    }

    public static TradeBuilder buyMixedStyle(Consumer<TradeBuilder> consumer) {
        return buildTrade(consumer, TypeOfTrade.BUY);
    }

    public static TradeBuilder sellMixedStyle(Consumer<TradeBuilder> consumer) {
        return buildTrade(consumer, TypeOfTrade.SELL);
    }

    private static TradeBuilder buildTrade(Consumer<TradeBuilder> consumer, TypeOfTrade buy) {
        TradeBuilder builder = new TradeBuilder();
        builder.trade.setType(buy);
        consumer.accept(builder);
        return builder;
    }

}
