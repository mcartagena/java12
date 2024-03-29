package com.mcartagena.learnjava.functional;

import java.util.List;
import java.util.function.Consumer;

public class Market {
    private static void checkPrices(List<Double> prices,
                                    Consumer<Double> scanner) {
        prices.forEach(scanner);
    }
    public static void main(String[] right) {
        List<Double> prices = List.of(1.2, 6.5, 3.0);
        checkPrices(prices,
                p -> {
                    String result = p<5 ? "Correct" : "Too high";
                    System.out.println(result);
                });
    }

}
