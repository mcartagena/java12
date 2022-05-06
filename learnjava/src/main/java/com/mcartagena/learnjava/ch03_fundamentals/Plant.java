package com.mcartagena.learnjava.ch03_fundamentals;

class Bush extends Plant {
    String type = "bush";
}
public class Plant {
    String type = "plant";
    final public static void main(String[] args) {
        Plant w1 = new Bush();
        Bush w2 = new Bush();
        Plant w3 = w2;
        System.out.print(w1.type+","+w2.type+","+w3.type);
    }
}
