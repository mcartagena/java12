package com.mcartagena.learnjava.exceptions;

public class Football {
    public static void main(String[] args) {
        try {
            System.out.print('A');
            throw new ArrayIndexOutOfBoundsException();
        } catch (RuntimeException r) {
            System.out.print('B');
            throw r;
        } catch (Exception e) {
            System.out.print('C');
        } finally {
            System.out.print('D');
        }
    }
}
