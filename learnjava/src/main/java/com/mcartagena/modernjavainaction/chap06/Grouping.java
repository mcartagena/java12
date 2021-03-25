package com.mcartagena.modernjavainaction.chap06;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.mcartagena.modernjavainaction.chap06.Dish.dishTags;
import static com.mcartagena.modernjavainaction.chap06.Dish.menu;
import static java.util.stream.Collectors.*;

public class Grouping {
    public static void main(String[] args) {
        // Dishes grouped by type:
        System.out.println("Dishes grouped by type:" + groupingDishesByType());
        // Dish names grouped by type:
        System.out.println("Dish names grouped by type:" + groupingDishesNameByType());
        // Dish tags grouped by type:
        System.out.println("Dish tags grouped by type:" + groupingDishesTagsByType());
        // Caloric dishes grouped by type:
        System.out.println("Caloric dishes grouped by type:" + groupingCaloricDishesByType());
        // Dishes grouped by caloric level:
        System.out.println("Dishes grouped by caloric level:" + groupDishesByCaloricLevel());
        // Dishes grouped by type and caloric level:
        System.out.println("Dishes grouped by type and caloric level:" + groupDishesByTypeAndCaloricLevel());
        // Count dishes in groups by Type:
        System.out.println("Count dishes in groups by Type:" + countDishesInGroupsByType());
        // Most caloric dishes by type:
        System.out.println("Most caloric dishes by type:" + mostCaloriesDishesByType());
        // Most caloric dishes by type without optional:
        System.out.println("Most caloric dishes by type without optional: " + mostCaloriesDishesByTypeWithoutOptional());
        // Sum calories by type:
        System.out.println("Sum calories by type: " + sumCaloriesByType());
        // Caloric levels by type:
        System.out.println("Caloric levels by type: " + caloricLevelByType());

    }

    public static Map<Type, List<Dish>> groupingDishesByType(){
        return menu.stream().collect(groupingBy(Dish::getType));
    }
    public static Map<Type, List<String>> groupingDishesNameByType(){
        return menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName,toList())));
    }
    public static Map<Type, Set<String>> groupingDishesTagsByType(){
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(),toSet())
                ));
    }
    public static Map<Type, List<Dish>> groupingCaloricDishesByType(){
        //return menu.stream().filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
        return menu.stream().collect(groupingBy(Dish::getType,filtering(dish -> dish.getCalories() > 500,toList())));
    }
    public static Map<CaloricLevel,List<Dish>> groupDishesByCaloricLevel(){
        return menu.stream().collect(groupingBy(
                dish -> {
                    if(dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }
        ));
    }
    public static Map<Type, Map<CaloricLevel,List<Dish>>> groupDishesByTypeAndCaloricLevel(){
        return menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if(dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                })));
    }
    public static Map<Type,Long> countDishesInGroupsByType(){
        return menu.stream().collect(
                groupingBy(Dish::getType,counting())
        );
    }
    public static Map<Type, Optional<Dish>>  mostCaloriesDishesByType(){
        return menu.stream().collect(groupingBy(
                Dish::getType,reducing((dish, dish2) -> dish.getCalories() > dish2.getCalories()? dish:dish2)
                ));
    }
    public static Map<Type, Dish>  mostCaloriesDishesByTypeWithoutOptional(){
        return menu.stream().collect(groupingBy(
                Dish::getType, collectingAndThen(reducing((dish, dish2) -> dish.getCalories() > dish2.getCalories()? dish:dish2),Optional::get)
        ));
    }
    public static Map<Type,Long> sumCaloriesByType(){
        return menu.stream().collect(groupingBy(Dish::getType,summingLong(Dish::getCalories)));
    }
    public static Map<Type,Set<CaloricLevel>>  caloricLevelByType(){
        return menu.stream().collect(groupingBy(Dish::getType,
                mapping(dish -> {
                    if(dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                },toSet())
        ));
    }
}
