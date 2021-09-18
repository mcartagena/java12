package com.mcartagena.learnjava.general;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Plumber {
    String value() default "Mario";
}

public class Team {
    @Plumber("")
    private String foreman = "Mario";
    @Plumber
    private String worker = "Kelly";
    @Plumber("Kelly")
    private String trainee;

    public static void main(String[] args) {
        var t = new Team();
        var fields = t.getClass().getDeclaredFields();

        System.out.println("fields size: " + fields.length);

        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getAnnotation(Plumber.class));
            if (field.isAnnotationPresent(Plumber.class)) {
                System.out.println("The annotation is present");
                System.out.println(field.getAnnotation(Plumber.class).value());
            } else {
                System.out.println("The annotation is not present");
            }
        }

    }
}
