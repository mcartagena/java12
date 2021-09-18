package com.mcartagena.learnjava.general;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) @interface Furry{
    public String[] value();
    boolean cute() default true;
}

public @Furry("Soft") class Bunny {

   public static int hop() {
        return 1;
    }
}
