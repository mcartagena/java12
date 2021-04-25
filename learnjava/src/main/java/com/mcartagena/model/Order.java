package com.mcartagena.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Order {
    private String customer;
    private List<Trade> trades = new ArrayList<>();
}
