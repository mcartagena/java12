package com.mcartagena.learnjava.general;

@interface Dance {
    long rhytm() default 66;
    int[] value();
    String track() default "";
    final boolean fast = true;
}

public class SingAnnotation {
    @Dance({2, 3}) String album;
}
