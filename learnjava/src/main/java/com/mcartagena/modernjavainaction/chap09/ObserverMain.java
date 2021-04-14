package com.mcartagena.modernjavainaction.chap09;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 & 9 in Action!");

        Feed feedLambda = new Feed();

        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! With Lambda " + tweet);
            }
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... With Lambda" + tweet);
            }
        });

        feedLambda.notifyObservers("Money money money, give me money!");
    }

    interface Observer {
        void notify(String tweet);
    }

    interface Subject {
        void registerObserver(Observer o);
        void notifyObservers(String tweet);
    }

    public static class NYTimes implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet!=null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " +  tweet);
            }
        }
    }

    public static class Guardian implements Observer {

        @Override
        public void notify(String tweet) {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet more news from London... " + tweet);
            }
        }
    }

    public static class LeMonde implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet != null && tweet.contains("wine")){
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    public static class Feed implements Subject{

        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer observer) {
            this.observers.add(observer);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(observer -> observer.notify(tweet));
        }
    }
}
