package com.mcartagena.datastructure;

/**
 * There are N stacks of coins, numbered from 0 to N−1. The Kth stack has A[K] coins.
 * In one move we can pick two coins from any stack we choose, put the first coin away and
 * place the second coin on the adjacent stack (either to the left or to the right of the
 * original stack).
 * <p>
 * What is the maximum number of coins that can be accumulated in a single stack?
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, recording the heights of the stacks, returns the
 * maximum number of coins that can be accumulated in one stack after performing any number
 * of moves as described above.
 * <p>
 * Examples:
 * <p>
 * 1. Given A = [2, 3, 1, 3], the function should return 5. A possible sequence of moves is:
 * [2, 3, 1, 3] → [0, 4, 1, 3] → [0, 4, 2, 1] → [0, 5, 0, 1].
 * <p>
 * 2. Given A = [3, 7, 0, 5], the function should return 9. A possible sequence of moves is:
 * [3, 7, 0, 5] → [1, 8, 0, 5] → [1, 8, 1, 3] → [1, 8, 2, 1] → [1, 9, 0, 1].
 * <p>
 * 3. Given A = [1, 1, 1, 1, 1], the function should return 1. No move can be performed.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..200,000];
 * each element of array A is an integer within the range [0..100,000,000].
 */

public class StacksOfCoins {

    public static int solution(int[] A) {

        int result = 0;
        int[] leftCoins = countCoinsLeft(A);
        int[] rightCoins = countCoinsRight(A);

        for (int i = 0; i < A.length; i++) {
            int coins = leftCoins[i] + A[i] + rightCoins[i];
            result = Math.max(result, coins);
        }

        return result;
    }

    public static int[] countCoinsLeft(int[] A) {
        int coins = 0;
        int[] numCoins = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            numCoins[i] = coins;
            coins = (coins + A[i]) / 2;
        }

        return numCoins;
    }

    public static int[] countCoinsRight(int[] A) {
        int coins = 0;
        int[] numCoins = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            numCoins[i] = coins;
            coins = (coins + A[i]) / 2;
        }

        return numCoins;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 3}));
        System.out.println(solution(new int[]{3, 7, 0, 5}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}));
    }
}
