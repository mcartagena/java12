package com.mcartagena.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final TypeOfFood typeOfFood;

    public Dish(String name, boolean vegetarian, int calories, TypeOfFood typeOfFood) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.typeOfFood = typeOfFood;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                '}';
    }

    public static final List<Dish> menu = asList(
            new Dish("pork", false, 800, TypeOfFood.MEAT),
            new Dish("beef", false, 700, TypeOfFood.MEAT),
            new Dish("chicken", false, 400, TypeOfFood.MEAT),
            new Dish("french fries", true, 530, TypeOfFood.OTHER),
            new Dish("rice", true, 350, TypeOfFood.OTHER),
            new Dish("season fruit", true, 120, TypeOfFood.OTHER),
            new Dish("pizza", true, 550, TypeOfFood.OTHER),
            new Dish("prawns", false, 400, TypeOfFood.FISH),
            new Dish("salmon", false, 450, TypeOfFood.FISH)
    );

    public static final Map<String, List<String>> dishTags = new HashMap<>();

    static {
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
    }

}
