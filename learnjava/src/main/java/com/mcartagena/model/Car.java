package com.mcartagena.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Car {
    private Brand brand;
    private Color color;
}
