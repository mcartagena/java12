package com.mcartagena.learnjava.streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TicketTaker {
    long ticketsSold;
    final AtomicInteger ticketsTaken;

    public TicketTaker() {
        ticketsSold = 0;
        ticketsTaken = new AtomicInteger(0);
    }

    public void performJob() {
        IntStream.iterate(1, p -> p + 1)
                .parallel()
                .limit(100)
                .forEach(i -> ticketsTaken.getAndIncrement());
        IntStream.iterate(1, q -> q + 1)
                .parallel()
                .limit(500)
                .forEach(i -> ++ticketsSold);
        System.out.print(ticketsTaken + " " + ticketsSold);
    }

    public static void main(String[] matinee) {
        new TicketTaker().performJob();
    }
}

