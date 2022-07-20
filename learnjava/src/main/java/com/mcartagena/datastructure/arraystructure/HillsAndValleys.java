package com.mcartagena.datastructure.arraystructure;

/**
 * Charlemagne, the king of Frankia, is considering building some castles on the border with
 * Servia.  The border is divided into N segments.  The king knows the height of the terrain in
 * each segment of the border.  The height of each segment of terrain is stored in array A, with
 * A[P] denoting the height of the P-th segment of the border.  The King has decided to build a
 * castle on top of every hill and in the bottom of every valley.
 * <p>
 * Let [P..Q] denote a group of consecutive segments from P to Q inclusive such that (0 <= P <= Q <= N-1).
 * Segments [P..Q] form a hill or a valley if all the following conditions are satisfied:
 * <p>
 * - The terrain height of each segment from P to Q is the same (A[P] = A[P+1] = ... = A[Q]);
 * - If P > 0 then A[P-1] < A[P] (for a hill) or A[P-1] > A[P] (for a valley);
 * - If Q < N-1 then A[Q+1] < A[Q] (for a hill) or A[Q+1] > A [Q] (for a valley);
 * <p>
 * That is, a hill is higher than its surroundings and a valley is lower than its surroundings.  Note
 * that if the surronding on  either side of the hill or vallley don't exist (i.e. at the edges of the
 * area under consideration, where P = 0 or Q = N-1), then the condition is considered satisfied
 * for that side of the hill / valley.
 * <p>
 * The king is wondering how many castles is he going to build.  Can you help him?
 * <p>
 * For example, consider the following array A = [2,2,3,4,3,3,2,2,1,1,2,5]
 * <p>
 * There are two hills: [3..3] and [11..11].  There are also two valleys: [0..1] and [8..9].  There are no
 * other suitable places for castles.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, as explained above, returns the total number of
 * hills and valleys.
 * <p>
 * For example, given array A as described above, the function should return 4.
 * <p>
 * Given array A = [-3,-3] describing segments with a terrain height below 0, segment [0..1]
 * forms both a hill and a valley, and only one castle can be built, so the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * - N is an integer within the range [1..100,000]
 * - each element of array A is an integer within the range [-1,000,000,000..1,000,000,000].
 */

public class HillsAndValleys {
    public static int solution(int[] A) {
        // write your code in Java SE 11
        if (A.length == 0)
            return 0;

        int countValleys = 0;
        int countHills = 0;
        int startValley = A[0];
        boolean hasStarted = true;
        boolean goingUp = false;
        boolean goingDown = false;

        // count valleys
        for (int i = 1; i < A.length; i++) {
            if (startValley < A[i] && hasStarted) {
                countValleys++;
                goingUp = true;
                goingDown = false;
                hasStarted = false;
            } else if (startValley < A[i] && !hasStarted && goingDown) {
                countValleys++;
                goingUp = true;
                goingDown = false;
            } else if (startValley > A[i] && hasStarted) {
                countHills++;
                goingUp = false;
                goingDown = true;
                hasStarted = false;
            } else if (startValley > A[i] && !hasStarted && goingUp) {
                countHills++;
                goingUp = false;
                goingDown = true;
            }
        }

        return countValleys + countHills + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5}));
        System.out.println(solution(new int[]{-3,-3}));
        System.out.println(solution(new int[]{1,2}));
        System.out.println(solution(new int[]{1, 1, 3, 3}));
    }
}
