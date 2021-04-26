package com.mcartagena.model;

import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Car {
    private Brand brand;
    private Color color;
    private Insurance insurance;
    private Optional<Insurance> insuranceOptional;

    public Optional<Insurance> getInsuranceAsOptional() {
        return Optional.ofNullable(insurance);
    }
}
