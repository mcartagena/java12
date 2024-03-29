package com.mcartagena.learnjava.exceptions;

public class WhaleSharkException extends Exception {

    public WhaleSharkException() {
        super("Friendly shark!");
    }

    public WhaleSharkException(String message) {
        super(new Exception(new WhaleSharkException()));
    }

    public WhaleSharkException(Exception cause) {
    }

}
