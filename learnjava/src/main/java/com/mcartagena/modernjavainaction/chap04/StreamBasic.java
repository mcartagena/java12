package com.mcartagena.modernjavainaction.chap04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    public static void main(String[] args) {
        
        System.out.println("---> Java 7");

        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---> Java 8");

        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish: dishes){
            if(dish.getCalories()<400){
                lowCaloricDishes.add(dish);
            }
        }

        List<String> lowCaloricDishesName = new ArrayList<>();

        Collections.sort(lowCaloricDishes,new Comparator<Dish>(){
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        for(Dish dish: lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }

        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
    
}
