package com.mcartagena.learnjava.annotations;

public @interface Thermometer {
        int minTemp();
    int maxTemp() default 1; // Integer DON'T COMPILE
    double[] color();
    String type = "CONSTANTE";  // final DON'T COMPILE and it has to be initialized
    boolean compact = true;  // Boolean DON'T COMPILE and it has to be initialized
}
