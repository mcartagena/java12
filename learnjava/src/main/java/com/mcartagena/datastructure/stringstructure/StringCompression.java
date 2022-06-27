package com.mcartagena.datastructure.stringstructure;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Implement a method for perform basic string compression using the counts of repeated characters.  For example,
 * the string aabcccccaaa would become a2b1c5a3.  If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.  You can assume the string has only uppercase and lowercase
 * letters (a-z).
 * Hints:
 * 1. Do the easy thing first.  Compress the string, then compare the lengths.
 * 2. Be careful that you aren't repeatedly concatening string together.  This can be very inefficient.
 */

public class StringCompression {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the string to compress:");
        String userInput = bufferReader.readLine();

        String result = compressString(userInput);

        System.out.println(result);

        bufferReader.close();
    }

    private static String compressString(String str) {

        int finalLength = countCompressLength(str);
//        System.out.println(finalLength);
        if (str.length() < finalLength) {
            return str;
        }

        int countSeries = 0;

        StringBuilder result = new StringBuilder(finalLength);
        Character currentCharacter = str.charAt(1);
        result.append(currentCharacter);

        for (Character c : str.toCharArray()) {
            if (currentCharacter == c) {
                countSeries++;
            } else {
                result.append(countSeries);
                countSeries = 1;
                currentCharacter = c;
                result.append(c);
            }
        }
        result.append(countSeries);

        return result.toString();
    }

    public static int countCompressLength(String str) {
        int countSeries = 0;
        int countFinalLength = 0;

        Character currentCharacter = str.charAt(1);

        for(Character c: str.toCharArray()){
            if(c == currentCharacter){
                countSeries++;
            } else {
                countFinalLength += 1 + String.valueOf(countSeries).length();
                currentCharacter = c;
                countSeries = 1;
            }
        }
        countFinalLength += 1 + String.valueOf(countSeries).length();

        return countFinalLength;
    }
}
