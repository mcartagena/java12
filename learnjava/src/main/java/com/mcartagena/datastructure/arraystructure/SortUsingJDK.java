package com.mcartagena.datastructure.arraystructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortUsingJDK {
    public static void main(String[] args) {
        var input = new BufferedReader(new InputStreamReader(System.in));
        String inputUser = "";

        System.out.println("Please, enter 7 numbers separated by space:");

        try {
            inputUser = input.readLine();
        } catch (IOException io) {
            io.printStackTrace();
        }

        String[] arrayStr = inputUser.split("\\s");
        int[] arrayInt = new int[arrayStr.length];

        for (int index = 0; index < arrayStr.length; index++) {
            arrayInt[index] = Integer.parseInt(arrayStr[index]);
        }

//        Arrays.sort(arrayInt);
        Arrays.parallelSort(arrayInt);

        System.out.println("The sort array is: " + Arrays.toString(arrayInt));

    }
}
