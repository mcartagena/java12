package com.mcartagena.learnjava.functional;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class TicketTaker {
    private static int AT_CAPACITY = 100;

    public int takeTicket(int currentCount,
                          IntUnaryOperator counter) {  // we can't apply a generic as Integer, remember it's a primitive type

        return counter.applyAsInt(currentCount);
    }

    public static void main(String... theater) {
        final TicketTaker bob = new TicketTaker();
        final int oldCount = 50;
        final int newCount = bob.takeTicket(oldCount, t -> {
            if (t > AT_CAPACITY) {
                throw new RuntimeException(
                        "Sorry, max has been reached");
            }
            return t + 1;
        });
        System.out.print(newCount);

        Predicate<String> dash = c -> c.startsWith("-");  // DOESN'T COMPILE is you don't put the generic
        System.out.println(dash.test("–"));

        Consumer clear = x -> System.out.println(x);  // works anyway without generic
        clear.accept("pink");

        Comparator<String> c = (String s, String t) -> 0;
        System.out.println(c.compare("s", "t"));


    }
}
