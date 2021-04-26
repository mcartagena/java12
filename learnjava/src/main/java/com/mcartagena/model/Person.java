package com.mcartagena.model;

import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Person {
    private int age;
    private String name;
    private Car car;
    private Optional<Car> carOptional;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
