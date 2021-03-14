package com.mcartagena.modernjavainaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.mcartagena.modernjavainaction.chap04.Dish.menu;

public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Suma:" + sum);

        int sum2 = numbers.stream().reduce(0,Integer::sum);

        System.out.println("Suma 2:" + sum2);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        max.ifPresent(System.out::println);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        min.ifPresent(System.out::println);

        // How would you count the number of dishes in a stream using the map and reduce methods?
        int numberOfDishes =  menu.stream().map(dish -> dish.getName().length() > 0? 1: 0).reduce(0,Integer::sum);

        System.out.println("Number of Dishes availables:");
        System.out.println(numberOfDishes);

        long numberOfDishes2 = menu.size();

        System.out.println(numberOfDishes2);

        int numberOfDishes3 = menu.parallelStream().map(dish -> dish.getName().length() > 0? 1: 0).reduce(0,Integer::sum);

        System.out.println(numberOfDishes3);

    }
}
