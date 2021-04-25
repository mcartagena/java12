package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.dsl.Order;
import com.mcartagena.model.dsl.Stock;
import com.mcartagena.model.dsl.Trade;
import com.mcartagena.model.dsl.TypeOfTrade;

import static com.mcartagena.modernjavainaction.chap10.MethodChainingOrderBuilder.forCustomer;
import static com.mcartagena.modernjavainaction.chap10.MixedBuilder.*;
import static com.mcartagena.modernjavainaction.chap10.NestedFunctionOrderBuilder.*;

public class DslOrchestator {
    public static void main(String[] args) {
        DslOrchestator main = new DslOrchestator();
        main.plain();
        main.methodChaining();
        main.nestedFunction();
        main.lambda();
        main.mixed();
    }

    public void plain(){
        Order order = new Order();
        order.setCustomer("BigBank");

        Trade trade1 = new Trade();
        trade1.setType(TypeOfTrade.BUY);

        Stock stock1 = new Stock();
        stock1.setSymbol("IBM");
        stock1.setMarket("NYSE");

        trade1.setStock(stock1);
        trade1.setPrice(125.00);
        trade1.setQuantity(80);
        order.addTrade(trade1);

        Trade trade2 = new Trade();
        trade2.setType(TypeOfTrade.BUY);

        Stock stock2 = new Stock();
        stock2.setSymbol("GOOGLE");
        stock2.setMarket("NASDAQ");

        trade2.setStock(stock2);
        trade2.setPrice(375.00);
        trade2.setQuantity(50);
        order.addTrade(trade2);

        System.out.println("Plain:");
        System.out.println(order);
    }

    public void methodChaining() {
        Order order = forCustomer("BigBank")
                .buy(80).stock("IBM").on("NYSE").at(125.00)
                .sell(50).stock("GOOGLE").on("NASDAQ").at(375.00)
                .end();

        System.out.println("Method chaining:");
        System.out.println(order);
    }

    public void nestedFunction() {
        Order order = order("BigBank",
                buy(80,
                        stock("IBM", on("NYSE")),
                        at(125.00)),
                sell(50,
                        stock("GOOGLE", on("NASDAQ")),
                        at(375.00))
        );

        System.out.println("Nested function:");
        System.out.println(order);
    }

    public void lambda() {
        Order order = LambdaOrderBuilder.order( o -> {
            o.forCustomer( "BigBank" );
            o.buy( t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell( t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });

        System.out.println("Lambda:");
        System.out.println(order);
    }

    public void mixed() {
        Order order =
                forCustomerMixedStyle("BigBank",
                        buyMixedStyle(t -> t.quantityMixedStyle(80)
                                .stockMixedStyle("IBM")
                                .onMixStyle("NYSE")
                                .at(125.00)),
                        sellMixedStyle(t -> t.quantityMixedStyle(50)
                                .stockMixedStyle("GOOGLE")
                                .onMixStyle("NASDAQ")
                                .at(375.00)));

        System.out.println("Mixed:");
        System.out.println(order);
    }

}
