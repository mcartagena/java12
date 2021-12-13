package com.mcartagena.learnjava.annotations;

import java.lang.annotation.Documented;

enum Colors { RED, BLUE, GREEN }
@Documented
public @interface Bouncy {
    int value();
    Colors color() default Colors.RED;
    double size();
}
@Bouncy(value=999, size=10.0) class Trampoline {}  // DON'T COMPILE if we put only the value 999 it has to be pair value and value

