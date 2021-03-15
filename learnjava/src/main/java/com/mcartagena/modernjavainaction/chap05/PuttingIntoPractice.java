package com.mcartagena.modernjavainaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> year2011Transactions = transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high).");
        year2011Transactions.forEach(System.out::println);

        // Query 2: What are all the unique cities where the traders work?
        List<String> citiesWhereTradersWork = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println("Query 2: What are all the unique cities where the traders work?");
        citiesWhereTradersWork.forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<String> tradersFromCabridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());

        System.out.println("Query 3: Find all traders from Cambridge and sort them by name.");
        System.out.println(tradersFromCabridge);

        // Query 4: Return a string of all traders' names sorted alphabetically.
        String traders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(a,b) -> a + " " + b);

        System.out.println("Query 4: Return a string of all traders' names sorted alphabetically.");
        System.out.println(traders);

        // Query 5: Are there any trader based in Milan?
        List<Trader> tradersBasedInMilan = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Milan"))
                .collect(toList());

        System.out.println("Query 5: Are there any trader based in Milan?");
        tradersBasedInMilan.forEach(System.out::println);

        // Query 5: Are there any trader based in Milan?
        boolean milanBased = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        // Query 6: Print all transactions' values from the traders living in Cambridge.
        List<Integer> valuesFromCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());

        System.out.println("Query 6: Print all transactions' values from the traders living in Cambridge.");
        valuesFromCambridge.forEach(System.out::println);

        // Query 7: What's the highest value in all the transactions?
        Optional<Integer> maxValueOfAllTransactions = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println("Query 7: What's the highest value in all the transactions?");
        maxValueOfAllTransactions.ifPresent(System.out::println);

        // Find the transaction with the smallest value
        Optional<Transaction> transactionWithSmallestValue = transactions.stream()
                .min(comparing(Transaction::getValue));

        System.out.println("Find the transaction with the smallest value");
        System.out.println(transactionWithSmallestValue.map(String::valueOf).orElse("No transactions found..."));

    }
}
