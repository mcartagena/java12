package com.mcartagena.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Insurance {
    private String name;
    private List<Employee> employees;
}
