package com.mcartagena.learnjava.general;

class Tool {
    private void repair() {
    }            // r1

    void use() {
    }                       // r2
}

public class Hammer extends Tool {
    private int repair() {
        return 0;
    } // r3

    void use() {
    }              // r4

    public void bang() {
    }              // r5

}
