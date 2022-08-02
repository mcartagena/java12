package com.mcartagena.datastructure.arraystructure;

import java.util.Arrays;

/**
 * You have just rolled a dice several times.  The N roll results that you remember are described
 * by an array A.  However, there are F rolls whose results you have forgotten.  The arithmetic
 * mean of all of the roll results (the sum of all the roll results divided by the number of rolls)
 * equals M.
 * <p>
 * What are the possible results of the missing rolls?
 * <p>
 * Write a function:
 * class Solution { public int[] solution(int[] A, int F, int M); }
 * <p>
 * that, given an Array A of length N, an integer F and an integer M, returns an array containing
 * possible results of the missed rolls.  The returned array should contain F integers from 1 to 6
 * (valid dice rolls).  If such an array does not exist then the function should return [0].
 * <p>
 * Examples:
 * <p>
 * 1.- Given A = [3,2,4,3], F=2, M=4, your function should return [6,6].  The arithmetic mean of
 * all the rolls is (3+2+4+3+6+6)/6=24/6=4.
 * <p>
 * 2.- Given A = [1,5,6], F=4, M=3, your function may return [2,1,2,4] or [6,1,1,1] (among others).
 * <p>
 * 3.- Given A = [1,2,3,4], F=4, M=6, your function should return [0].  It is not possible to obtain such a mean.
 * <p>
 * 4.- Given A = [6,1], F=1, M=1, your function should return [0].  It is not possible to obtain such a
 * mean.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * - N and F are integers within the range [1..100,000];
 * - each element of array A is an integer within the range [1..6];
 * - M is an integer within the range [1..6].
 * <p>
 * Remember, all submissions are being checked for plagiarism.  Your recruiter will be informed
 * in case suspicious activity is detected.
 */

public class MissedRolls {
    public static int[] missedRolls(int[] A, int F, int M) {
        // write your code in Java SE 11
        int[] result = new int[F];
        int[] fail = new int[]{0};
        int left = M * (A.length + F) - sumArray(A);

        int valueForEachElement = left / F;
        int restForElement = left % F;

        /*System.out.println("value for each element" + valueForEachElement);
        System.out.println("rest for each element" + restForElement); */

        if (valueForEachElement > 0 && valueForEachElement <= 6) {
            if (restForElement > 0 && valueForEachElement > 5) {
                return fail;
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = valueForEachElement;
                if (restForElement > 0) {
                    result[i] += 1;
                    restForElement -= 1;
                }
            }
        } else {
            return fail;
        }

        // System.out.println("result " + Arrays.toString(result));

        return result;
    }

    public static int sumArray(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(missedRolls(new int[]{3, 2, 4, 3}, 2, 4)));
        System.out.println(Arrays.toString(missedRolls(new int[]{1, 5, 6}, 4, 3)));  //your function may return [2,1,2,4] or [6,1,1,1] (among others).
        System.out.println(Arrays.toString(missedRolls(new int[]{1, 2, 3, 4}, 4, 6)));
        System.out.println(Arrays.toString(missedRolls(new int[]{6,1}, 1, 1)));
        System.out.println(Arrays.toString(missedRolls(new int[]{1}, 1, 3)));


    }
}
