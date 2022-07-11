package com.mcartagena.datastructure.stringstructure;

import java.util.Arrays;
import java.util.Stack;

/**
 * Let us define a transformation that, given a string S of letters 'a' and/or 'b', replaces some consecutive
 * sequence "abb" in S by "baa".
 * <p>
 * For example, after applying such a transformation to the string "abbabb", both strings "baaabb"
 * and "abbbaa" can be obtained.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public String solution(String S); }
 * <p>
 * that, given a string S of length N, returns the alphabetically largest string that can be obtained by
 * performing the above operation any number of times.
 * <p>
 * Examples:
 * <p>
 * 1. Given S = "ababb", your function should return "baaaa".
 * "baaaa" is alphabetically the largest possible outcome and may be obtained from "ababb" by using two transformations:
 * "ababb" → "abbaa" → "baaaa"
 * <p>
 * 2. Given S = "abbbabb", your function should return "babaaaa".
 * "babaaaa" may be obtained from "abbbabb" by using three transformations:
 * "abbbabb" → "abbbbaa" → "baabbaa" → "babaaaa"
 * <p>
 * 3. Given S = "aaabab", your function should return "aaabab".
 * No operation can be performed on S since it contains no "abb" fragment.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * string S consists only of the characters "a" and/or "b".
 */

public class LargestString {

    public static String solution(String S) {
        char[] temp = new char[3];
        char[] handleString = S.toCharArray();
        int i = 0;
        while (i < handleString.length - 2) {
            temp[0] = handleString[i];
            temp[1] = handleString[i + 1];
            temp[2] = handleString[i + 2];
            if (isEqualPattern(temp)) {
                handleString[i] = 'b';
                handleString[i + 1] = 'a';
                handleString[i + 2] = 'a';
                i = Math.max(i - 2, 0);
            } else {
                i += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < handleString.length; j++) {
            sb.append(handleString[j]);
        }
        return sb.toString();
    }

    public static boolean isEqualPattern(char[] str) {
        char[] pattern = new char[]{'a', 'b', 'b'};

        return Arrays.equals(pattern, str);

    }

    public static void main(String[] args) {
        System.out.println(solution("ababb"));
        System.out.println(solution("abbbabb"));
        System.out.println(solution("aaabab"));
    }

}
