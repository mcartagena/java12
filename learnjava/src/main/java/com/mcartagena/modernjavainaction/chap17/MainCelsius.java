package com.mcartagena.modernjavainaction.chap17;

import java.util.concurrent.Flow;

public class MainCelsius {
    public static void main(String[] args) {

        getCelsiusTemperatures("New York").subscribe(new TempSubscriber());
    }

    public static Flow.Publisher<TempInfo> getCelsiusTemperatures(String town) {
        return subscriber -> {
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
