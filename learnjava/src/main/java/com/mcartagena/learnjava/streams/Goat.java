package com.mcartagena.learnjava.streams;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Goat {
    private String food;

    public Goat(String food) {
        this.food = food;
    }

    public static void main(String[] args) {
        var goats = List.of(
                new Goat("can"),
                new Goat("hay"),
                new Goat("shorts"),
                new Goat("hay")
        );

        goats.stream()
                .collect(Collectors.groupingBy(Goat::getFood))
//                .forEach((k, v) -> System.out.println("key " + k + " value " + v));
//        key hay value [Goat(food=hay), Goat(food=hay)]
//        key can value [Goat(food=can)]
//        key shorts value [Goat(food=shorts)]
                .entrySet()
                .stream()
                .filter(stringListEntry -> stringListEntry.getValue().size() ==  2)
                .map(stringListEntry -> stringListEntry.getKey())
                .collect(Collectors.partitioningBy(String::isEmpty))
//                .forEach((k, v) -> System.out.println("key " + k + " value " + v));
//        key false value [hay]
//        key true value []
                .get(false)
                .stream()
                .sorted()
                .forEach(System.out::print);
//        hay

    }

}
