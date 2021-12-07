package com.mcartagena.learnjava.exceptions;

class FunEvent implements AutoCloseable {
    private final int value;

    FunEvent(int value) {
        this.value = value;
    }

    public void close() {
        System.out.print(value);
    }
}

public class Hapenning {

    public static void main(String[] args) {
        FunEvent e = new FunEvent(1);
        try (e; var f = new FunEvent(8)) {
            System.out.print("2");
            throw new ArithmeticException();
        } catch (Exception x) {
            System.out.print("3");
        } finally {
            System.out.print("4");
        }

    }

}
