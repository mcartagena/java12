package com.mcartagena.datastructure.arraystructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is
 * represented by an integer, write a method to rotate the image by 90 degrees.  Can you do this in
 * place?
 */

public class RotateMatrix {

    public static boolean rotate(int[][] matrix) {

        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                // left to top
                matrix[first][i] = matrix[last - offset][first];
                // bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right to bottom
                matrix[last][last - offset] = matrix[i][last];
                // top to right
                matrix[i][last] = top;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        var input = new BufferedReader(new InputStreamReader(System.in));
        String inputUser = "";

        System.out.println("Enter the matrix lenght n and then the matrix. Example:");
        System.out.println("3");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");

        inputUser = input.readLine();
        int n = Integer.parseInt(inputUser);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] arrayStr = input.readLine().replaceAll("\\s+$", "").split(" ");
            int[] arrayInt = new int[arrayStr.length];

            for (int index = 0; index < arrayStr.length; index++) {
                arrayInt[index] = Integer.parseInt(arrayStr[index]);
            }
            matrix[i] = arrayInt;
        }

        if(rotate(matrix)){
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }

        input.close();
    }
}
