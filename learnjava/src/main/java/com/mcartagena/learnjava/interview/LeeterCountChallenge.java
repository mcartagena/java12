package com.mcartagena.learnjava.interview;

import java.util.*;

/*
Letter Count:
Have the function LetterCount(str) take the str parameter being passed
and return the first word with the greatest number of repeated letters.
For example: "Today, is the greatest day ever!" should return greatest
because it has 2 e's (and 2 t's) and it comes before ever which also have
2 e's.  If there are no words with repeating letters return -1.  Words will
be separated by spaces.

Examples:
Input:  "Hello apple pie"
Output: Hello

Input: "No words"
Output: -1

 */


class LeeterCountChallenge {

    public static String LetterCount(String str) {
        // code goes here
        Map<String,Integer> countLetters = new LinkedHashMap<>();
        List<String> firstWord = new ArrayList<>();
        String resultString = "-1";

        if(Optional.ofNullable(str).isPresent()) {
            String[] words = str.split(" ");

            for(String word: words){
                int count = countLetterByWord(word);
                countLetters.put(word,count);
            }

            // get the max value of the letters
            int currentMaxValue = 1;
            for(Map.Entry<String,Integer> entry: countLetters.entrySet()){
                int entryValue = entry.getValue();
                if(entryValue > currentMaxValue){
                    currentMaxValue = entryValue;
                }
            }

            if(currentMaxValue > 1) {
                for(Map.Entry<String,Integer> entry: countLetters.entrySet()){
                    int entryValue = entry.getValue();
                    if(entryValue == currentMaxValue){
                        resultString = entry.getKey();
                        break;
                    }
                }
            }
        }

        return resultString;
    }

    public static int countLetterByWord(String input){
        int count = 1;
        Map<Character, Integer> numberOfLetters = new HashMap<>();

        for(int i = 0;i < input.length(); i++){
            char letter = input.charAt(i);
            if(!numberOfLetters.containsKey(letter)) {
                int result = 0;
                int jump = i + 1;
                while(result != -1){
                    result = input.indexOf(letter,jump);
                    if(result!=-1){
                        jump = result + 1;
                        count++;
                    }
                }
                numberOfLetters.put(letter,count);
                count = 1;
            }
        }

        // get the max value of the map
        int currentMaxValue = 1;
        for(Map.Entry<Character, Integer> entry: numberOfLetters.entrySet()){
            int entryValue = entry.getValue();
            if(entryValue > currentMaxValue){
                currentMaxValue = entryValue;
            }
        }

        if(currentMaxValue > count)
            count = currentMaxValue;

        return count;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCount(s.nextLine()));
    }

}
