package com.mcartagena.learnjava.general;

interface GameItem {
    int sell();
}
abstract class Vegetable implements GameItem {
    public final int sell() { return 5; }
}

public class Turnip extends Vegetable{

    public static void main(String[] expensive) {
        System.out.print(new Turnip().sell());
    }

}
