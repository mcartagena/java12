package com.mcartagena.modernjavainaction.chap06;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.mcartagena.modernjavainaction.chap06.Dish.menu;
import static java.util.stream.Collectors.*;

public class Partitioning {
    public static void main(String[] args) {
        // Dishes partitioned by vegetarian:
        System.out.println("Dishes partitioned by vegetarian: " + dishesParitionedByVegetarian());
        // Vegetarian Dishes by type:
        System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
        // Most caloric dishes by vegetarian:
        System.out.println("Most caloric dishes by vegetarian: " + mostCaloricDishByVegetarian());
    }

    private static Map<Boolean,Dish> mostCaloricDishByVegetarian() {
        Comparator<Dish> comparatorDish = Comparator.comparingInt(Dish::getCalories);
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(comparatorDish),Optional::get)));
    }

    private static Map<Boolean,Map<Type,List<Dish>>> vegetarianDishesByType() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
    }

    private static Map<Boolean, List<Dish>> dishesParitionedByVegetarian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }
}
