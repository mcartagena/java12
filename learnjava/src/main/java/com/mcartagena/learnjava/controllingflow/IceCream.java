package com.mcartagena.learnjava.controllingflow;

public class IceCream {
    public static void main(String[] args) {
        var flavors = 30;
        int eaten = 0;
        switch (flavors) {
            case 30:
                eaten++;
            case 40:
                eaten += 2;
            default:
                eaten--;
        }
        System.out.println(eaten);

        System.out.println("----------");

        for (int k = 0; k < 5; k++) {
            System.out.print(k);
        }
        System.out.println("\n----------");

        for (int k = 1; k <= 5; k++) {
            System.out.print(k);
        }
        System.out.println("\n----------");

        int k = 0;
        do {
            System.out.print(k);
        } while (k++ < 5);
        System.out.println("\n----------");

        int j = 0;
        while (j++ < 5) {
            System.out.print(j);
        }

    }
}
