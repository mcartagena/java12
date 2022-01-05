package com.mcartagena.learnjava.io;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arrayInt = new int[7];

        var console = System.console();
        if (console == null) {
            throw new RuntimeException("Console don't available");
        }

        System.out.println("Please, enter 7 numbers separated by space.");

        String text = console.readLine();
        String[] arrayStr = text.split("\\s");

        for (int index = 0; index < arrayStr.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        for(int gap = arrayInt.length/2 ; gap > 0 ; gap/=2){
//            System.out.println("gap: " + gap);
            InsertedSort.insertedSort(arrayInt, gap);
        }

        System.out.println("Array sorted: " + Arrays.toString(arrayInt));

    }
}
