package com.mcartagena.learnjava.interview;

/*
 * [H]ave the function StringScramble(str1,str2) take both parameters being passed and return
 * the string "true" if a portion of str1 characters can be rearranged to match str2 is "world"
 * the output should return "true".  Punctuation and symbols will not be entered with the parameters.
 * */

public class StringScrambleChallenge {
    public static void main(String[] args) {
        System.out.println(stringScramble("ollhe", "hello"));  // true
        System.out.println(stringScramble("rkqodlw", "world"));  // true
        System.out.println(stringScramble("heloooolwrdlla", "helloworld")); // true
        System.out.println(stringScramble("fruit", "tomato"));  // false
        System.out.println(stringScramble("otamot", "tomato"));  // true
        System.out.println(stringScramble(null, "tomato"));  // false
        System.out.println(stringScramble("rkqodlw", "world"));  // true

    }

    public static String stringScramble(String str1, String str2) {

        if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
            return "false";

        if(str1.length() < str2.length())
            return "false";

        for(int index = 0; index < str2.length(); index++ )
            if(!str1.contains(str2.substring(index, index + 1)))
                return "false";

        return "true";
    }
}
