package com.mcartagena.learnjava.exceptions;

import java.io.IOException;

class Organ {
    public void operate() throws IOException {
        throw new RuntimeException("Not supported");
    }
}

public class Heart extends Organ {
    public void operate() throws IOException {    // Exception { DOESN'T COMPILE
        System.out.print("beat");
    }

    public static void main(String... c) throws Exception {
        try {
            new Heart().operate();
        } finally {
            System.out.print("!");
        }
    }
}

