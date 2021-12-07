package com.mcartagena.learnjava.exceptions;

abstract class Duck {
    protected int count;

    public abstract int getDuckies();
}

public class Ducklings extends Duck {
    private int age;

    public Ducklings(int age) {
        this.age = age;
    }

    public int getDuckies() {
        return this.age / count;
    }

    public static void main(String[] pondInfo) {
        Duck itQuacks = new Ducklings(5);
        System.out.print(itQuacks.getDuckies());
    }
}
