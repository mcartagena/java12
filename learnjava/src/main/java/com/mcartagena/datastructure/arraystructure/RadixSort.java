package com.mcartagena.datastructure.arraystructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String[] arrayStr = new String[6];
        int[] arrayInt = new int[6];

        System.out.println("Enter 6 numbers of 4 digits separated by space:");
        try {
            String userStr = userInput.readLine();
            arrayStr = userStr.split("\\s");
        } catch (IOException io) {
            io.printStackTrace();
        }
        for (int index = 0; index < arrayStr.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

        radixSort(arrayInt, 10, 4);

        System.out.println("Array sorted: " + Arrays.toString(arrayInt));
    }

    public static void radixSort(int[] array, int radix, int with) {
        for (int index = 0; index < with; index++) {
            radixSimpleSort(array, index, radix);
        }
    }

    public static void radixSimpleSort(int[] array, int position, int radix) {
        int numItems = array.length;
        int[] countingArray = new int[radix];
        for (int value : array) {
            countingArray[getDigit(position, value, radix)]++;
        }
        System.out.println("countingArray: " + Arrays.toString(countingArray));

        // adjust array
        for (int index = 1; index < countingArray.length; index++) {
            countingArray[index] += countingArray[index - 1];
        }

        System.out.println("Adjust countingArray: " + Arrays.toString(countingArray));

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countingArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        System.out.println("temp Array: " + Arrays.toString(temp));

        System.arraycopy(temp, 0, array, 0, numItems);

        System.out.println("array int: " + Arrays.toString(array));

    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
