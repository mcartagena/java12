package com.mcartagena.datastructure.stringstructure;

import java.util.Scanner;

public class PermuteString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s;
        String answer = "";

        System.out.print("Enter the string : ");
        s = scan.next();

        System.out.print("\nAll possible strings are : ");
        int n = s.length();
        permute(s, 0, n - 1);
    }

    private static void permute(String s, int left, int right) {
        if (left == right) {
            System.out.println(s);
            return;
        }
        for (int i = left; i <= right; i++) {
            s = swap(s, left, i);
            permute(s, left + 1, right);
            s = swap(s, left, i);
        }

    }

    public static String swap(String s, int i, int j) {
        char[] sArray = s.toCharArray();
        char temp = sArray[i];
        sArray[i] = sArray[j];
        sArray[j] = temp;
        return String.valueOf(sArray);
    }
}
