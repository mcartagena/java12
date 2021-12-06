package com.mcartagena.learnjava.exceptions;

public class Remember {
    public static void think() throws Exception {  // k1
        try {
            throw new Exception();
        } catch (RuntimeException r) {
        }               // k2
    }

    public static void main(String... ideas) throws Exception {

        think();
    }
}
