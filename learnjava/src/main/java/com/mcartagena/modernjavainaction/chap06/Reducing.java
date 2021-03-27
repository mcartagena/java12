package com.mcartagena.modernjavainaction.chap06;

import static com.mcartagena.modernjavainaction.chap06.Dish.menu;
import static java.util.stream.Collectors.reducing;

public class Reducing {

    public static void main(String[] args) {

        // Total calories in menu:
        System.out.println("Total calories in menu: " + totalCaloriesInMenu());
        // Calculate Total Calories With Method Reference
        System.out.println("Calculate Total Calories With Method Reference: " + calculeTotalCaloriesWithMethodReference());
        // Calculate Total Calories Without Collectors
        System.out.println("Calculate Total Calories Without Collectors: " + calculateTotalCaloriesWithoutCollectors());
        // Calculate Total Calories Using Sum
        System.out.println("Calculate Total Calories Using Sum: " + calculateTotalCaloriesUsingSum());

    }

    public static Integer totalCaloriesInMenu(){
        return menu.stream().collect(reducing(0,Dish::getCalories,(calories1, calories2) -> calories1 + calories2));
    }

    public static Integer calculeTotalCaloriesWithMethodReference(){
        return menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
    }

    public static Integer calculateTotalCaloriesWithoutCollectors(){
        return menu.stream().map(Dish::getCalories).reduce(0,Integer::sum);
    }

    public static Integer calculateTotalCaloriesUsingSum(){
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

}
