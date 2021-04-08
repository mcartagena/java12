package com.mcartagena.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Employee {
    private int id;
    private String name;
    private Division division;
    private Date startDt;
}
