package com.mcartagena.learnjava.general;

import java.lang.annotation.Documented;

enum Color {GREY, BROWN}

@Documented public @interface Dirt {
    boolean wet();
    String type() default "unknow";
    public Color color();
    static final int slipperry = 5;
}
