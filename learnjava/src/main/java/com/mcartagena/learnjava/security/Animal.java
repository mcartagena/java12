package com.mcartagena.learnjava.security;

import java.util.ArrayList;

public final class Animal implements Cloneable {
    private final ArrayList<String> favoriteFoods;

    public Animal(ArrayList<String> favoriteFoods) {
        if (favoriteFoods == null)
            throw new RuntimeException("favoriteFoods is required");
        this.favoriteFoods = (ArrayList) favoriteFoods.clone();
    }

    public Animal clone() {
        ArrayList<String> listClone = (ArrayList) favoriteFoods.clone();
        return new Animal(listClone);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<String> food = new ArrayList<>();
        food.add("grass");
        Animal sheep = new Animal(food);
        Animal clone = (Animal) sheep.clone();
        System.out.println(sheep == clone);  // false
        clone.favoriteFoods.add("meat");
        System.out.println(sheep.favoriteFoods == clone.favoriteFoods);  // false
        System.out.println(sheep.favoriteFoods.size()); // 1
        System.out.println(clone.favoriteFoods.size()); // 2
    }

}
