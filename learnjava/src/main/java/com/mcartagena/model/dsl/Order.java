package com.mcartagena.model.dsl;


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

    public void addTrade( Trade trade ) {
        trades.add( trade );
    }

    public double getValue() {
        return trades.stream().mapToDouble( Trade::getValue ).sum();
    }
}
