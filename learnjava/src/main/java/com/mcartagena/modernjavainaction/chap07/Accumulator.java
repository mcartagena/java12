package com.mcartagena.modernjavainaction.chap07;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Accumulator {
    private long total;

    public void add(long value){
        total += value;
    }
}
