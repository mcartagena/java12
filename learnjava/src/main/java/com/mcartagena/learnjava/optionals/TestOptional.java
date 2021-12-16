package com.mcartagena.learnjava.optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class TestOptional {
    private static void longer(Optional<Boolean> opt) {
        if (opt.isPresent())
            System.out.println("run: " + opt.get());

        Supplier<Double> intMethodReference = Math::random;
    }
    private static void shorter(Optional<Boolean> opt) {
        opt.map(x -> "run: " + x)
                .ifPresent(System.out::println);
    }

}
