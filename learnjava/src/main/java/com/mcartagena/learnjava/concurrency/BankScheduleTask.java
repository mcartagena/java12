package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankScheduleTask {
    static int cookies = 0;
    public synchronized void deposit(int amount) {
        cookies += amount;
    }
    public static synchronized void withdrawal(int amount) {
        cookies -= amount;
    }
    public static void main(String[] amount) throws Exception {
        var teller = Executors.newScheduledThreadPool(50);
        BankScheduleTask bank = new BankScheduleTask();
        for(int i=0; i<25; i++) {
            teller.submit(() -> bank.deposit(5));
            teller.submit(() -> bank.withdrawal(5));
        }
        teller.shutdown();
        teller.awaitTermination(10, TimeUnit.SECONDS);
        System.out.print(bank.cookies);
    }

}
