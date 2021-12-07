package com.mcartagena.learnjava.exceptions;

class MissedCallException extends Exception {
}

public class Phone {
    static void makeCall() throws RuntimeException, MissedCallException {
        throw new ArrayIndexOutOfBoundsException("Call");
    }

    public static void main(String[] messages) {
        try {
            makeCall();
        } catch (MissedCallException e) {
            throw new RuntimeException("Voicemail");
        } finally {
            throw new RuntimeException("Text");
        }
    }
}
