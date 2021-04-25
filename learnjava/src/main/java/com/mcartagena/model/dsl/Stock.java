package com.mcartagena.model.dsl;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@ToString
public class Stock {
    private String symbol;
    private String market;
}
