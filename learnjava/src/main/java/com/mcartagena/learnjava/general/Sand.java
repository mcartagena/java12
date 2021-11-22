package com.mcartagena.learnjava.general;

import java.util.Arrays;

public class Sand {
    private static int numShovels;
    private int numRakes;

    public static int getNumShovels() {
        return numShovels;
    }

/*    public static int getNumRakes() {
        return numRakes;
    }*/

    public Sand() {
        System.out.print("a");
    }

    public void Sand() {
        System.out.print("b");
    }

    public void run() {
        new Sand();
        Sand();
    }

    public void printVarargs(String... names) {
        System.out.println(Arrays.toString(names));
    }

    public void printArray(String[] names) {
        System.out.println(Arrays.toString(names));
    }

    public void stormy() {

        printVarargs("Arlene");
        printVarargs(new String[]{"Bret"});
        printVarargs(null);
//        printArray("Cindy");  does not compile
        printArray(new String[]{"Don"});
        printArray(null);
    }

    public static void main(String... args) {
        new Sand().run();
    }

}
