package com.mcartagena.datastructure.matrix;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Given a 6 x 6 2D Array, arr:
 * 
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0 
 * 
 * We define an hourglass in A to be a subset of values with indices falling in this 
 * pattern in arr's graphical representation:
 * 
 * a b c
 *   d
 * e f g
 * 
 * There aren 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. 
 * Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
 * 
 * For example, given the 2D array:
 * 
 * -9 -9 -9  1 1 1 
 * 0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 * 0  0  8  6 6 0
 * 0  0  0 -2 0 0
 * 0  0  1  2 4 0
 * 
 * We calculate the following 16 hourglass values:
 * 
 * -63, -34, -9, 12, 
 * -10, 0, 28, 23, 
 * -27, -11, -2, 10, 
 * 9, 17, 25, 18
 * 
 * Our highest hourglass value is from the hourglass:
 * 
 * 0 4 3
 *   1
 * 8 6 6
 * 
 * Function Description
 * 
 * Complete the function hourglassSum in the editor below. It should return an integer, 
 * the maximum hourglass sum in the array.
 * 
 * hourglassSum has the following parameter(s):
 *    arr: an array of integers 
 * 
 * Input Format
 * 
 * Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].
 * 
 * Constrains
 * 
 *   -9 <= arr[i][j] <= 9
 *   0 <= i,j <= 5
 * 
 * Output Format
 * Print the largest (maximum) hourglass sum found in arr.
 * 
 * Sample Input
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * 
 * Sample Output
 * 19
 * 
 * Explanation
 * arr contains the following hourglasses:
 * 
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   1       0       0       0
 * 1 1 1   1 1 0   1 0 0   0 0 0
 * 
 * 0 1 0   1 0 0   0 0 0   0 0 0
 *   1       1       0       0
 * 0 0 2   0 2 4   2 4 4   4 4 0
 * 
 * 1 1 1   1 1 0   1 0 0   0 0 0
 *   0       2       4       4
 * 0 0 0   0 0 2   0 2 0   2 0 0
 * 
 * 0 0 2   0 2 4   2 4 4   4 4 0
 *   0       0       2       0
 * 0 0 1   0 1 2   1 2 4   2 4 0
 * 
 * The hourglass with the maximum sum (19) is:
 * 
 * 2 4 4
 *   2
 * 1 2 4
 * 
 */


public class TwoDArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = -1000;
        for(int i=0;i<4;++i){
            for(int j=0;j<4;++j){
                int count = 0;
                int l = i;
                for(int k=j;k<(j+3);++k){
                    if(arr[l][k]>0)
                        count = count + arr[l][k];
                    else 
                        count = count - (arr[l][k]*-1);
                    System.out.println("count " + count + " value " + arr[l][k]);
                }
                ++l;
                count += arr[l][j+1];
                ++l;
                for(int k=j;k<(j+3);++k){
                    if(arr[l][k]>0)
                        count = count + arr[l][k];
                    else 
                        count = count - (arr[l][k]*-1);
                    System.out.println("count " + count + " value " + arr[l][k]);
                }
                if(max<count)
                    max = count;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
