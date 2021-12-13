package com.mcartagena.learnjava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

@Target(ElementType.TYPE_USE)
@interface Friend {
    String value();
    String lastName() default "null";  // DON'T COMPILE if it's treated as null instead of string
    int age = 10;
}
public class MyFriends {
    void makeFriends() {
        var friends = List.of(new @Friend("Olivia") Object(),
                new @Friend("Adeline") String(),
                new @Friend("Henry") MyFriends());
    }
}
