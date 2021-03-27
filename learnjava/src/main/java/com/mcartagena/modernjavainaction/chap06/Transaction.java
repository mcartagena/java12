package com.mcartagena.modernjavainaction.chap06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Transaction {
    private final Currency currency;
    private final double value;
}
