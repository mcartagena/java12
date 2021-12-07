package com.mcartagena.learnjava.exceptions;

public class Computer {
    public void compute() throws Exception {
        throw new NullPointerException("Does not compute!");
    }

    public static void main(String[] b) throws Exception {
        try {
            new Computer().compute();
        } catch (RuntimeException e) {
            System.out.print("zero");
            throw e;
        } catch (Exception e) {
            System.out.print("one");
            throw e;
        }
    }

}
