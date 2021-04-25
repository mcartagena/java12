package com.mcartagena.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Person {
    private int age;
    private String name;
}
