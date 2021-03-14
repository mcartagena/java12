package com.mcartagena.modernjavainaction.chap05;

import com.mcartagena.modernjavainaction.chap04.Dish;

import java.util.Arrays;
import java.util.List;

import static com.mcartagena.modernjavainaction.chap04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Filtering {
    public static void main(String[] args) {
        // filtering with predicate
        System.out.println("Filtering with a predicate");

        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        System.out.println("Filtering unique elements:");

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // Slicing a stream
        // This list is soted in ascening order of number of calories!
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("Filtered sorted menu:");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        filteredMenu.forEach(System.out::println);

        System.out.println("Sorted menu sliced with takeWhile()");
        List<Dish> sliceMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(toList());
        sliceMenu1.forEach(System.out::println);

        System.out.println("Sorted menu sliced wih dropWhile()");
        List<Dish> sliceMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(toList());

        sliceMenu2.forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());

        System.out.println("Truncating a stream");
        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());

        System.out.println("Skipping elements: ");
        dishesSkip2.forEach(System.out::println);

    }

}
