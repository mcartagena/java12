package com.mcartagena.learnjava.general;

public class Cars {
    private static void drive() {
        {
            System.out.println("static");
        }
        System.out.println("fast");
        {
            System.out.println("faster");
        }

    }

    public static void main(String[] args) {
        drive();
        drive();
    }

}
