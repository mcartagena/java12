package com.mcartagena.datastructure.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) {

        String factorialToCalculate = "0";

        var userInput = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        System.out.println("Input the factorial to calculate: ");
        try{
            factorialToCalculate = userInput.readLine();
        } catch (IOException io){
            io.printStackTrace();
        }

        System.out.println("The factorial es: " + factorial(Integer.parseInt(factorialToCalculate)));

    }
    public static int factorial(int num){
        if(num==0)
            return 1;
        return num * factorial(num - 1);
    }

}
