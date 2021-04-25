package com.mcartagena.modernjavainaction.chap06;

import com.mcartagena.model.CaloricLevel;
import com.mcartagena.model.Dish;
import com.mcartagena.model.TypeOfFood;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.mcartagena.model.Dish.dishTags;
import static com.mcartagena.model.Dish.menu;
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

    public static Map<TypeOfFood, List<Dish>> groupingDishesByType(){
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood));
    }
    public static Map<TypeOfFood, List<String>> groupingDishesNameByType(){
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood, mapping(Dish::getName,toList())));
    }
    public static Map<TypeOfFood, Set<String>> groupingDishesTagsByType(){
        return menu.stream().collect(
                groupingBy(Dish::getTypeOfFood,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(),toSet())
                ));
    }
    public static Map<TypeOfFood, List<Dish>> groupingCaloricDishesByType(){
        //return menu.stream().filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood,filtering(dish -> dish.getCalories() > 500,toList())));
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
    public static Map<TypeOfFood, Map<CaloricLevel,List<Dish>>> groupDishesByTypeAndCaloricLevel(){
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood,
                groupingBy(dish -> {
                    if(dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if(dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                })));
    }
    public static Map<TypeOfFood,Long> countDishesInGroupsByType(){
        return menu.stream().collect(
                groupingBy(Dish::getTypeOfFood,counting())
        );
    }
    public static Map<TypeOfFood, Optional<Dish>>  mostCaloriesDishesByType(){
        return menu.stream().collect(groupingBy(
                Dish::getTypeOfFood,reducing((dish, dish2) -> dish.getCalories() > dish2.getCalories()? dish:dish2)
                ));
    }
    public static Map<TypeOfFood, Dish>  mostCaloriesDishesByTypeWithoutOptional(){
        return menu.stream().collect(groupingBy(
                Dish::getTypeOfFood, collectingAndThen(reducing((dish, dish2) -> dish.getCalories() > dish2.getCalories()? dish:dish2),Optional::get)
        ));
    }
    public static Map<TypeOfFood,Long> sumCaloriesByType(){
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood,summingLong(Dish::getCalories)));
    }
    public static Map<TypeOfFood,Set<CaloricLevel>>  caloricLevelByType(){
        return menu.stream().collect(groupingBy(Dish::getTypeOfFood,
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
