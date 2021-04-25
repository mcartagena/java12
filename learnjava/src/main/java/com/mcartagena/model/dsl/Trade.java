package com.mcartagena.model.dsl;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Trade {
    private TypeOfTrade type;

    private Stock stock;
    private int quantity;
    private double price;

    public double getValue() {
        return quantity * price;
    }
}
