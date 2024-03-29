package com.mcartagena.learnjava.io;

import java.util.Arrays;

public class InsertedSort {
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

        insertedSort(arrayInt, 1);

        System.out.println("Array sorted: " + Arrays.toString(arrayInt));
    }

    public static void insertedSort(int[] array, int gap){
        for(int lastIndexSort = gap; lastIndexSort < array.length; lastIndexSort++){
            int lastValue = array[lastIndexSort];
            int index;
            for(index = lastIndexSort; index >= gap && lastValue < array[index - gap]; index-=gap){
//                System.out.println("swaping..." + array[index] + " " + array[index - gap]);
                array[index] = array[index - gap];
            }
//            System.out.println("swaping..." + array[index] + " " + lastValue);
            array[index] = lastValue;
        }
    }
}
