package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static com.mcartagena.model.Dish.menu;
import static com.mcartagena.modernjavainaction.chap10.GroupingBuilder.groupOn;
import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                Car.builder().brand(Brand.MAZDACX5).color(Color.GREEN).build(),
                Car.builder().brand(Brand.MAZDACX5).color(Color.RED).build(),
                Car.builder().brand(Brand.MAZDACX5).color(Color.BLUE).build(),
                Car.builder().brand(Brand.MAZDACX7).color(Color.GREEN).build(),
                Car.builder().brand(Brand.MAZDACX7).color(Color.WHITE).build(),
                Car.builder().brand(Brand.MAZDA2).color(Color.GREEN).build(),
                Car.builder().brand(Brand.MAZDA3).color(Color.RED).build());

        Map<Brand, Map<Color, List<Car>>> carsByBrandAndColor =
                cars.stream().collect(groupingBy(Car::getBrand,
                        groupingBy(Car::getColor)));

        System.out.println("Grouping Cars by brand and color: " + carsByBrandAndColor);

        Collector<? super Car, ?, Map<Brand, Map<Color, List<Car>>>>
                carGroupingCollector =
                groupOn(Car::getColor).after(Car::getBrand).get();

        Map<Brand, Map<Color, List<Car>>> carsByBrandAndColorWithCarGroupingCollector =
                cars.stream().collect(carGroupingCollector);

        System.out.println("Grouping Cars by brand and color using GroupingBuilder: " + carsByBrandAndColorWithCarGroupingCollector);

        // Using a Grouping Builder
        System.out.println("Using a Grouping Builder");

        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel2());
        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel3());

    }

    private static CaloricLevel getCaloricLevel(Dish dish ) {
        if (dish.getCalories() <= 400) {
            return CaloricLevel.DIET;
        }
        else if (dish.getCalories() <= 700) {
            return CaloricLevel.NORMAL;
        }
        else {
            return CaloricLevel.FAT;
        }
    }

    private static Map<TypeOfFood, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel2() {
        return menu.stream().collect(
                twoLevelGroupingBy(Dish::getTypeOfFood, dish -> getCaloricLevel(dish))
        );
    }

    public static <A, B, T> Collector<T, ?, Map<A, Map<B, List<T>>>> twoLevelGroupingBy(Function<? super T, ? extends A> f1, Function<? super T, ? extends B> f2) {
        return groupingBy(f1, groupingBy(f2));
    }

    private static Map<TypeOfFood, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel3() {
        Collector<? super Dish, ?, Map<TypeOfFood, Map<CaloricLevel, List<Dish>>>> c = groupOn((Dish dish) -> getCaloricLevel(dish)).after(Dish::getTypeOfFood).get();
        return menu.stream().collect(c);
    }

}
