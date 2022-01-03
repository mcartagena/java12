package com.mcartagena.learnjava.io;

import java.util.Arrays;

public class InsertedSort {
    public static void main(String[] args) {
        int[] arrayInt = new int[5];

        var console = System.console();
        if (console == null) {
            throw new RuntimeException("Console don't available");
        }

        String text = console.readLine();
        String[] arrayStr = text.split("\\s");

        for (int index = 0; index < arrayStr.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        insertedSort(arrayInt);

        System.out.println("Array sorted: " + Arrays.toString(arrayInt));
    }

    public static void insertedSort(int[] array){
        for(int lastIndexSort = 1; lastIndexSort < array.length; lastIndexSort++){
            int lastValue = array[lastIndexSort];
            int index;
            for(index = lastIndexSort; index > 0 && lastValue < array[index - 1]; index--){
                array[index] = array[index - 1];
            }
            array[index] = lastValue;
        }
    }
}
