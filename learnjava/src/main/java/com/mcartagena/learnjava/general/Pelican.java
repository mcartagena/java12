package com.mcartagena.learnjava.general;

abstract class Bird {
    private final void fly() {
        System.out.println("Bird");
    }

    protected Bird() {
        System.out.print("Wow-");
    }

    public class InnerClass{
        final int test = 0;
    }
}

public class Pelican extends Bird {
    public Pelican() {
        System.out.print("Oh-");
    }

    protected void fly() {
        System.out.println("Pelican");
    }

    public static void main(String[] args) {
        var chirp = new Pelican();
        chirp.fly();

        System.out.println(0 / 0);
    }
}

