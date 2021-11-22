package com.mcartagena.learnjava.general;

public interface Swimming {
    String DEFAULT = "Diving!";      // k1

    abstract int breath();

    private void stroke() {
        if (breath() == 1) {             // k2
            System.out.print("Go!");
        } else {
            System.out.print(dive());  // k3
        }
    }

    static String dive() {
        return DEFAULT;               // k4
    }

}
