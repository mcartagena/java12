package com.mcartagena.modernjavainaction.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED)
        );

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyAppples = filterHeavyApples(inventory);
        System.out.println(heavyAppples);

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples2);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples2);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples3 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples3);

        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "BROWN".equals(a.getColor()));
        System.out.println(weirdApples);

    }

    // Bad filtering 1
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    // Bad filtering 2
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory){
            if(apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return Color.GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }    
    
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();

        for(Apple a : inventory){
            if(p.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    enum Color{
        RED,
        GREEN
    }

    /**
     * Apple
     */
    public static class Apple {
    
        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }
        
    }

}
