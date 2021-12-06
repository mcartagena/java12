package com.mcartagena.learnjava.exceptions;

import java.io.IOException;

public class Light {
    public static void main(String[] v) throws Exception {
        try {
            new Light().turnOn();
        } catch (RuntimeException v1) {  // y1
            System.out.println(v);
            throw new IOException();     // y2
        } finally {
            System.out.println("complete");
        }
    }
    public void turnOn() throws IOException {
        new IOException("Not ready");   // y3
    }
}
