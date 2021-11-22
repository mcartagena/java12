package com.mcartagena.learnjava.general;

abstract class TestStaticMethod{
    static void printValue(){
        System.out.println("holea");
    }
}

@FunctionalInterface
interface Play {
    public static void baseball() {}
    private static void soccer() {}
    default void play() {}
    void fun();
}

public class Penguin {
    enum Baby {EGG}

    static class Chick {
        enum Baby {EGG}
        static void printValue(){
            System.out.println("holea");
        }
    }

    public static void main(String[] args) {
        boolean match = false;
        Baby egg = Baby.EGG;
        switch (egg) {
            case EGG:
                match = true;
        }
    }

}
