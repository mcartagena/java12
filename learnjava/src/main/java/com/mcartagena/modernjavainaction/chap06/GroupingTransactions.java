package com.mcartagena.modernjavainaction.chap06;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class GroupingTransactions {

    public static List<Transaction> transactions = Arrays.asList(
            new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0)
    );

    public static void main(String[] args) {
        // transactions By Currencies Group Imperatively
        System.out.println("transactions By Currencies Group Imperatively: " + groupImperatively());
        // transactions By Currencies Group Functionally
        System.out.println("transactions By Currencies Group Functionally: " + groupFunctionally());

    }

    public static Map<Currency, List<Transaction>> groupImperatively(){
        // Don't do it in this way, just for example as old versions
        Map<Currency,List<Transaction>> result = new HashMap<>();

        for(Transaction transaction: transactions){
            List<Transaction> temporalTransactions = new ArrayList<>();
            if(!result.containsKey(transaction.getCurrency())){
                result.put(transaction.getCurrency(),temporalTransactions);
            }
            temporalTransactions = result.get(transaction.getCurrency());
            temporalTransactions.add(transaction);
        }

        return result;
    }

    public static Map<Currency,List<Transaction>> groupFunctionally(){
        return transactions.stream().collect(groupingBy(Transaction::getCurrency));
    }
}
