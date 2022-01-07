package com.mcartagena.datastructure.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        var input = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            System.out.println("Enter 7 numbers separated by space: ");
            userInput = input.readLine();
        } catch (IOException io) {
            io.printStackTrace();
        }
        String[] arrayStr = userInput.split("\\s");
        int[] arrayInt = new int[7];

        for (int index = 0; index < 7; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        quickSort(arrayInt, 0, arrayInt.length);
        System.out.println("The sort array is: " + Arrays.toString(arrayInt));

    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start < 2)
            return;
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);

    }

    public static int partition(int[] array, int start, int end) {
        int fwIndex = start;
        int bkIndex = end;
        int pivot = array[start];

        while (fwIndex < bkIndex) {
            while (fwIndex < bkIndex && array[--bkIndex] > pivot);
            if (fwIndex < bkIndex)
                array[fwIndex] = array[bkIndex];
            while (fwIndex < bkIndex && array[++fwIndex] < pivot);
            if (fwIndex < bkIndex)
                array[bkIndex] = array[fwIndex];
        }

        array[fwIndex] = pivot;

        return fwIndex;
    }
}
