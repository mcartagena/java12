package com.mcartagena.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Builder
@ToString
public class Customer {
    private Long id;
    private String name;
    private String password;
    private String email;
    private final String reason = "PERFORMANCE_TEST";
}
