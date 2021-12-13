package com.mcartagena.learnjava.annotations;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

//m1
//@SuppressWarnings("unchecked")
public class Space {
    // m2
//    @SuppressWarnings("unchecked")
    final void frontier() {
        List<Object> stars = List.of(1,2,3);
        stars.add(4);  //DON'T COMPILE stars is a inmutable list

        // m3 if we put @SuppressWarnings("unchecked") we stil get warning of unchecked
        List planets = new ArrayList<>();
        planets.add(5);
    }

    public static void main(String[] args) {
        new Space().frontier();
    }
}

@interface Bread {
    public int maker = 5;
    String baker();
}

@Inherited
@interface Toast {
    boolean buttered() default true;
    int freshness() default Bread.maker;
    static boolean wheat = false;
}

