package com.mcartagena.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Trade {
    private Type type;
    private Stock stock;
    private int quantity;
    private double price;
}
