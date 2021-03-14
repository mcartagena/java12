package com.mcartagena.modernjavainaction.chap05;

import com.mcartagena.modernjavainaction.chap04.Dish;

import java.util.Optional;

import static com.mcartagena.modernjavainaction.chap04.Dish.menu;

public class Finding {

    public static void main(String[] args) {
        // filtering with predicate
        System.out.println("Finding in a stream...");

        if(isMenuFriendlyVegetarian())
            System.out.println("The menu is (somewhat) vegetarian friendly!!");

        if(isHealthyMenu())
            System.out.println("The menu is healthy. (allMatch)");

        if(isHealthyMenu2())
            System.out.println("The menu is healthy. (noneMatch)");

        Optional<Dish> dish = findVegetarianDish();

        dish.ifPresent(d -> System.out.println("findAny: " + d.getName()));
    }

    public static boolean isMenuFriendlyVegetarian(){
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    public static boolean isHealthyMenu(){
        return menu.stream().allMatch(dish -> dish.getCalories() < 1000);
    }

    public static boolean isHealthyMenu2(){
        return menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
    }

    public static Optional<Dish> findVegetarianDish(){
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
}
