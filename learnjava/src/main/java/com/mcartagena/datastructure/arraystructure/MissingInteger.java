package com.mcartagena.datastructure.arraystructure;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Write a function:
 * class Solution{ public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (grather than 0) that does
 * not ocurre in A.
 * <p>
 * For example, given A = [1,3,6,4,1,2] the function should return 5.
 * <p>
 * Given A = [1,2,3] the function should return 4.
 * Given A = [-1,-3] the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptiions:
 * <p>
 * - N is an integer within the range [1...100,000];
 * - each element of array A is an integer within the range [-1,000,000...1,000,000]
 */

public class MissingInteger {
    public int solution(int[] A) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            nums.add(i);
        }
        for(int a: A){
            nums.remove(a);
        }
        return nums.iterator().next();
    }

    public static void main(String[] args) {
        MissingInteger mi = new MissingInteger();
        System.out.println(mi.solution(new int[]{1,3,6,4,1,2}));
        System.out.println(mi.solution(new int[]{1,2,3}));
        System.out.println(mi.solution(new int[]{-1,-3}));
    }
}