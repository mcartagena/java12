package com.mcartagena.learnjava.annotations;

import java.util.ArrayList;

@interface Sword {
}

public @interface Zelda {
    public String game() default "new String()";  // DON'T COMPILE it has to be constant

    Sword sword();

    java.util.List<Integer> gems = new ArrayList<>();  // if it is a constant it has to be initialized.

    boolean hasBossKey();  // final DON'T COMPILE

    public abstract int level() default Integer.MAX_VALUE;

    boolean continues();  // protected DON'T compile and continue is reservaded
}

