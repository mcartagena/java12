package com.mcartagena.learnjava.general;

public class Chicken {
    private Integer eggs = 2;

    {
        this.eggs = 3;
    }

    public Chicken(int eggs) {
        this.eggs = eggs;
    }

    public static void main(String[] r) {
        var c1 = new Chicken(1);
        var c2 = new Chicken(2);
        var c3 = new Chicken(3);
        c1.eggs = c2.eggs;
        c2 = c1;
        c3.eggs = null;
    }

}
