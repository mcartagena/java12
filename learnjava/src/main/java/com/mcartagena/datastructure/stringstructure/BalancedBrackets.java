package com.mcartagena.datastructure.stringstructure;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        String result = "YES";
        Map<Character, Character> mapCloseBracket = new HashMap<>();
        mapCloseBracket.put('{','}');
        mapCloseBracket.put('[',']');
        mapCloseBracket.put('(',')');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length(); i++){
            Character value =  s.charAt(i);
            if(value == '{' ||  value == '[' || value == '('){
                stack.push(value);
            } else {
                if(stack.isEmpty()){
                    result = "NO";
                    break;
                }
                Character valueStack = stack.pop();

                if(mapCloseBracket.get(valueStack) != value){
                    result = "NO";
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            result = "NO";
        }

        return result;
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

