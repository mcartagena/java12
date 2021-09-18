package com.mcartagena.learnjava.general;

public class Dog {
    public String name;

    public void runAway() throws RuntimeException {
        System.out.print("1");
        try {
            System.out.print("2");
            int x = Integer.parseInt(name);
            System.out.print("3");
        } catch (NullPointerException e) {
            System.out.print("4");
        }
    }

    public static void main(String... args) {
        Dog webby = new Dog();
        webby.name = "Webby";
        webby.runAway();
        System.out.print("5");
    }

}
