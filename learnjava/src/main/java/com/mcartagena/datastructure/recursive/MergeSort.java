package com.mcartagena.datastructure.recursive;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        var console = System.console();

        if (console == null) {
            System.out.println("The console is not available...");
            return;
        }

        String userStr = console.readLine("Please, enter 7 numbers separated by space: ");

        String[] arrayStr = userStr.split("\\s");

        int[] arrayInt = new int[7];

        for (int index = 0; index < arrayInt.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        System.out.println(Arrays.toString(arrayInt));

//        mergeSort(arrayInt, 0, arrayInt.length);
        mergeSortDescending(arrayInt, 0, arrayInt.length);

        System.out.println("Array sorted: ");
        System.out.println(Arrays.toString(arrayInt));

    }

    public static void mergeSort(int[] array, int start, int end) {
        System.out.println(start + " - " + end);
        if ((end - start) < 2)
            return;

        int mid = (start + end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        if (array[mid - 1] <= array[mid]) {
            return;
        }

        int[] tempArray = new int[end - start];

        int index = start;
        int secondIndex = mid;
        int tempIndex = 0;

        while (index < mid && secondIndex < end) {
            tempArray[tempIndex++] = array[index] <= array[secondIndex] ? array[index++] : array[secondIndex++];
        }

        System.arraycopy(array, index, array, start + tempIndex, mid - index);  // copying the remaining of the first array
        System.arraycopy(tempArray, 0, array, start, tempIndex);  // copying the sorted temp array

    }

    public static void mergeSortDescending(int[] array, int start, int end) {
        System.out.println(start + " - " + end);
        if ((end - start) < 2)
            return;

        int mid = (start + end) / 2;

        mergeSortDescending(array, start, mid);
        mergeSortDescending(array, mid, end);
        mergeDescending(array, start, mid, end);
    }

    public static void mergeDescending(int[] array, int start, int mid, int end) {
        if (array[mid - 1] >= array[mid]) {
            return;
        }

        int[] tempArray = new int[end - start];

        int index = start;
        int secondIndex = mid;
        int tempIndex = 0;

        while (index < mid && secondIndex < end) {
            tempArray[tempIndex++] = array[index] >= array[secondIndex] ? array[index++] : array[secondIndex++];
        }

        System.arraycopy(array, index, array, start + tempIndex, mid - index);  // copying the remaining of the first array
        System.arraycopy(tempArray, 0, array, start, tempIndex);  // copying the sorted temp array
    }
}
