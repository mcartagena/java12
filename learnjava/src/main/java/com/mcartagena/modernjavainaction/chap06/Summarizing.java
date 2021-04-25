package com.mcartagena.modernjavainaction.chap06;

import com.mcartagena.model.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.BinaryOperator;

import static com.mcartagena.model.Dish.menu;
import static java.util.stream.Collectors.*;

public class Summarizing {

    public static void main(String[] args) {
        // Nr. of dishes:
        System.out.println("Nr. of dishes: " + howManyDishes());
        // The most caloric dish is:
        System.out.println("The most caloric dish is: " + findTheMostCaloricDish());
        // The most caloric dish using comparator is:
        System.out.println("The most caloric dish using comparator is: " + findTheMostCaloricDishUsingComparator());
        // Total calories in menu:
        System.out.println("Total calories in menu: " + calculeTotalCalories());
        // Total calories in menu:
        System.out.println("Total calories using summing int in menu: " + calculeTotalCaloriesUsingSummingInt());
        // Average calories in menu:
        System.out.println("Average calories in menu: " + averageCalories());
        // Menu statistics:
        System.out.println("Menu statistics: " + menuStatistics());
        // Short menu:
        System.out.println("Concatenating Menu Names: " + concatenatingMenuNames());
        // Short menu:
        System.out.println("Concatenating Menu Names Comma Separated: " + concatenatingMenuNamesCommaSeparated());
    }

    private static String concatenatingMenuNamesCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }

    private static String concatenatingMenuNames() {
        return menu.stream().map(Dish::getName).collect(joining());
    }


    private static IntSummaryStatistics menuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static Double averageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static Integer calculeTotalCaloriesUsingSummingInt() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Integer calculeTotalCalories() {
        return menu.stream().map(Dish::getCalories).reduce(0,Integer::sum);
    }

    private static Dish findTheMostCaloricDishUsingComparator() {
        Comparator<Dish> comparatorDish = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> dishBinaryOperator = BinaryOperator.maxBy(comparatorDish);
        return menu.stream().reduce(dishBinaryOperator).get();
    }

    private static Dish findTheMostCaloricDish() {
        return menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories))).get();
    }

    public static Long howManyDishes(){
        return (long) menu.size();
    }
}
