package com.mcartagena.modernjavainaction.chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        // [Apple{color=RED, weight=120}]
        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples = filterApplesByWeight(inventory, 150);
        System.out.println(heavyApples);

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, Color.GREEN, 0, true);
        System.out.println(greenApples2);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, null, 150, false);
        System.out.println(heavyApples2);

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples3 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples3);

        // [Apple{color=GREEN, weight=155}]
        List<Apple> heavyApples3 = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples3);

        // []
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // [Apple{color=RED, weight=120}]
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getColor() == Color.RED;
            }
        });

        System.out.println(redApples2);

        // Apple{weight=80}
        // Apple{weight=155}
        // Apple{weight=120}
        prettyPrintApple(inventory, new OnlyWeigthApplePredicate());

        // Apple{color=GREEN, weight=80, apple is Light}
        // Apple{color=GREEN, weight=155, apple is Weight}
        // Apple{color=RED, weight=120, apple is Light}
        prettyPrintApple(inventory, new EachAppleHeavyOfLight());

        // A light GREEN apple
        // A heavy GREEN apple
        // A light RED apple
        prettyPrintApple(inventory, new AppleFancyFormatter());

        // An apple of 80g
        // An apple of 155g
        // An apple of 120g
        prettyPrintApple(inventory, new AppleSimpleFormatter());

    }

    // first attempt of filter apples - bad code
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // second attempt of filter apples - bad code
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;

    }

    // second attempt of filter apples - bad code
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;

    }

    // third attempt of filter apples - bad code
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, PrintApplePredicate p) {
        for (Apple apple : inventory) {
            String output = p.print(apple);
            System.out.println(output);
        }
    }

    // Answer
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    interface ApplePredicate {

        boolean test(Apple a);

    }

    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }

    }

    static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }

    }

    static public class AppleRedAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    interface PrintApplePredicate {

        String print(Apple a);

    }

    // print only the weight of each apple
    static public class OnlyWeigthApplePredicate implements PrintApplePredicate {

        @Override
        public String print(Apple a) {
            return String.format("Apple{weight=%d}", a.getWeight());
        }

    }

    // print each apple individually and mention whether it’s heavy or light.
    static public class EachAppleHeavyOfLight implements PrintApplePredicate {
        @Override
        public String print(Apple a) {
            return String.format("Apple{color=%s, weight=%d, apple is %s}", a.getColor(), a.getWeight(),
                    a.getWeight() > 150 ? "Weight" : "Light");
        }
    }

    // Answer
    public interface AppleFormatter {
        String accept(Apple a);
    }

    static public class AppleFancyFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    static public class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    enum Color {
        RED, GREEN
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
