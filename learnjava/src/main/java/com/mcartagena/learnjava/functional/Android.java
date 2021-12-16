package com.mcartagena.learnjava.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Android {
    public void wakeUp(Supplier supplier) {             // d1
        supplier.get();
    }

    public static void main(String... electricSheep) {
        Android data = new Android();
        data.wakeUp(() -> 0); // d2

        var db = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(1,6)
                .parallel()
                .map(i -> {db.add(i); return i;})
                .forEachOrdered(System.out::print);  // p1
        System.out.println();
        db.forEach(System.out::print);          // p2


    }
}
