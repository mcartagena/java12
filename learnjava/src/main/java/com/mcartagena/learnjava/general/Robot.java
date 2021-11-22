package com.mcartagena.learnjava.general;

interface Pump {
    void pump(double psi);
}

interface Bend{
    void bend(double tensileStrength);
}

public class Robot {
    public static final void apply(
            Bend instruction, double input) {
        instruction.bend(input);
    }

    public static void main(String... future) {
        final Robot r = new Robot();
        r.apply(x -> System.out.print(x + " bent!"), 5);
    }

}
