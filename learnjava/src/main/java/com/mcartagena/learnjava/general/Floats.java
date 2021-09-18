package com.mcartagena.learnjava.general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
public @interface Floats {
    int buoyancy() default 2;
}
