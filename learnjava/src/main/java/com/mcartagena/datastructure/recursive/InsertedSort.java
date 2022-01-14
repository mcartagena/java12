package com.mcartagena.datastructure.recursive;

import java.util.Arrays;

public class InsertedSort {
    public static void main(String[] args) {
        var console = System.console();

        if (console == null) {
            System.out.println("Console is not available...");
            return;
        }

        String userInput = console.readLine("Enter 7 numbers separated by space: ");

        String[] arrayStr = userInput.split("\\s");
        int[] arrayInt = new int[arrayStr.length];

        for (int index = 0; index < arrayStr.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        insertedSort(arrayInt, 1, 1);

        System.out.println("The array sorted is: " + Arrays.toString(arrayInt));

    }

    public static void insertedSort(int[] array, int lastIndexSort, int gap) {
        if (lastIndexSort >= array.length) {
            return;
        }
        int lastValue = array[lastIndexSort];
        int index = swapInsertedSort(array, lastIndexSort, lastValue, gap);

        array[index] = lastValue;
        insertedSort(array, lastIndexSort + 1, gap);
    }

    public static int swapInsertedSort(int[] array, int index, int lastValue, int gap) {
        if (index < gap || lastValue >= array[index - gap])
            return index;

        array[index] = array[index - gap];
        return swapInsertedSort(array, index - gap, lastValue, gap);

    }

}
