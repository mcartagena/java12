package com.mcartagena.learnjava.concurrency;

import java.util.concurrent.Executors;

public class Riddle {
    public void sleep() {
        try { Thread.sleep(5000); } catch (Exception e) {}
    }
    public String getQuestion(Riddle r) {
        synchronized (r) {
            sleep();
            if(r != null) r.getAnswer(null);
            return "How many programmers does it take "
                    + "to change a light bulb?";
        }
    }
    public synchronized String getAnswer(Riddle r) {
        sleep();
        if(r != null) r.getAnswer(null);
        return "None, that's a hardware problem";
    }

    public static void main(String... ununused) {
        var r1 = new Riddle();
        var r2 = new Riddle();
        var s = Executors.newFixedThreadPool(2);
        s.submit(() -> r1.getQuestion(r2));
        s.execute(() -> r2.getAnswer(r1));
        s.shutdown();
    }

}
