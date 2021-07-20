package com.mcartagena.learnjava.general;

public class TestIfAssigment {
    public static void main(String[] args) {
        int b;
        if((b = 1)!=-1) System.out.println("Diferent -1 " + (b = 10));
        else System.out.println("Igual a -1");
    }
}
