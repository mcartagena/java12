package com.mcartagena.modernjavainaction.chap16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {
    private final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("NewOne"),
            new Shop("NewTwo"),
            new Shop("ShopEasy"),
            new Shop("NewThree"),
            new Shop("NewFour"),
            new Shop("NewFive"),
            new Shop("NewSix"),
            new Shop("NewSeven"),
            new Shop("NewEigth"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), (Runnable r) -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                //.map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .map(shop -> shop.getName() + " price is " + shop.getPriceWithDiscount(product))
                .collect(Collectors.toList());
    }
    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                //.map(shop -> shop.getName() + " price is " + shop.getPrice(product))
                .map(shop -> shop.getName() + " price is " + shop.getPriceWithDiscount(product))
                .collect(Collectors.toList());
    }
    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
/*                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                                + shop.getPrice(product)))  // without executor*/
/*                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                                + shop.getPrice(product), executor))*/
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is "
                                + shop.getPriceWithDiscount(product), executor))
                        .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscount(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }

    public void printPricesStream(String product) {
        long start = System.nanoTime();
        CompletableFuture[] futures = findPricesStream(product)
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }

    public List<String> findPricesInUSD(String product) {
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();
        for (Shop shop : shops) {
            // Start of Listing 10.20.
            // Only the type of futurePriceInUSD has been changed to
            // CompletableFuture so that it is compatible with the
            // CompletableFuture::join operation below.
            CompletableFuture<Double> futurePriceInUSD =
                    CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                            .thenCombine(
                                    CompletableFuture.supplyAsync(
                                            () ->  ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD))
                                            // Timeout management added in Java 9
                                            .completeOnTimeout(ExchangeService.DEFAULT_RATE, 1, TimeUnit.SECONDS),
                                    (price, rate) -> price * rate
                            )
                            // Timeout management added in Java 9
                            .orTimeout(3, TimeUnit.SECONDS);
            priceFutures.add(futurePriceInUSD);
        }
        // Drawback: The shop is not accessible anymore outside the loop,
        // so the getName() call below has been commented out.
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .map(price -> /*shop.getName() +*/ " price is " + price)
                .collect(Collectors.toList());
    }
}
