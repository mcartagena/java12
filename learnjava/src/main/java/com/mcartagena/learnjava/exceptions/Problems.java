package com.mcartagena.learnjava.exceptions;

class MissingMoneyException extends Exception{
}

class MissingFoodException extends Exception{
}

public class Problems {
    public void doIHaveAProblem()
            throws MissingMoneyException, MissingFoodException {
        System.out.println("No problems");
    }

    public static void main(String[] args) throws MissingMoneyException, MissingFoodException {
        try {
            final Problems p = new Problems();
            p.doIHaveAProblem();
        } catch (Exception e) {
            throw e;
        }

    }
}
