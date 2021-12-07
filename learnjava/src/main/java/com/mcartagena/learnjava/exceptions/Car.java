package com.mcartagena.learnjava.exceptions;

import java.io.IOException;

class CarCrash extends RuntimeException {
    CarCrash(Exception e) {}                               // w1
}

public class Car {
    public static void main(String[] s) throws Exception { // w2
        try {
            throw new IOException("Auto-pilot error");
        } catch (CarCrash e) { // (Exception | CarCrash e) {                  // w3 DON'T COMPILE CarCrash is a subclass of Exception
            throw e;
        } catch (Exception a) {                             // w4
            throw a;
        }
    }
}
