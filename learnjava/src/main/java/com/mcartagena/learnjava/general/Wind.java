package com.mcartagena.learnjava.general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface Strong {
    int force();
}

public @interface Wind {
    public static final int temperature = 20;
    boolean storm() default true;
    public int kiteFlying();
    String gusts();
    Strong power() default @Strong(force = 10);
}


