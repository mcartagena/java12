package com.mcartagena.learnjava.annotations;

public @interface Student {
    final boolean likesPonies = true;

    int value() default 100;

    int age();

    /**
     * TODO
     **/
    String name() default "Olivia";
}
