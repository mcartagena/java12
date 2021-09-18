package com.mcartagena.learnjava.general;

import java.lang.annotation.Inherited;

class Food{
    public void print(){
        @Unexpected(dessert = "hola") int local;
    }
}

@Inherited public @interface Unexpected {
    public String rsvp() default "null";
//    Food food();
    public String[] dessert();
    final int numberOfGuests = 5;
    long startTime() default 0L;
}
