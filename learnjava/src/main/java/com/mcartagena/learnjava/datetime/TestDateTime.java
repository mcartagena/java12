package com.mcartagena.learnjava.datetime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestDateTime {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2020, 5, 10, 11, 22, 33);
        var f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(ldt.format(f));
        f = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(ldt.format(f));

        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        System.out.println(dtf.format(zdt));

        dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        System.out.println(dtf.format(zdt));

    }
}
