package com.mcartagena.datastructure.arraystructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RadixSortString {
    public static void main(String[] args) {

        printCharacterNumericValue();

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String[] arrayStr = new String[5];

        System.out.println("Enter 5 strings of long 4 separated by space:");
        try {
            String userStr = userInput.readLine();
            arrayStr = userStr.split("\\s");
        } catch (IOException io) {
            io.printStackTrace();
        }

        radixSort(arrayStr, 27, 5);

        System.out.println("Array sorted: " + Arrays.toString(arrayStr));
    }

    public static void radixSort(String[] array, int radix, int with) {
        for (int index = 0; index < with; index++) {
            radixSimpleSort(array, index, radix);
        }
    }

    public static void radixSimpleSort(String[] array, int position, int radix) {
        int numItems = array.length;
        int[] countingArray = new int[radix];
        for (String value : array) {
            countingArray[getCharacter(position, value, radix)]++;
        }
        System.out.println("countingArray: " + Arrays.toString(countingArray));

        // adjust array
        for (int index = 1; index < countingArray.length; index++) {
            countingArray[index] += countingArray[index - 1];
        }

        System.out.println("Adjust countingArray: " + Arrays.toString(countingArray));

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countingArray[getCharacter(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        System.out.println("temp Array: " + Arrays.toString(temp));

        System.arraycopy(temp, 0, array, 0, numItems);

        System.out.println("array int: " + Arrays.toString(array));

    }

    public static int getCharacter(int position, String value, int radix) {
        int result = Character.getNumericValue(value.charAt(value.length() - position - 1)) - 10;
        System.out.println("getCharacter..." + result);
        return result;
    }

    public static void printCharacterNumericValue() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        for (int index = 0; index < str.length(); index++)
            System.out.println("number " + str.charAt(index) + " " + Character.getNumericValue(str.charAt(index)));
    }

}
