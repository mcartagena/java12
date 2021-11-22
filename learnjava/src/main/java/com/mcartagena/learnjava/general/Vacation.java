package com.mcartagena.learnjava.general;

enum DaysOff {
    Thanksgiving, PresidentsDay, ValentinesDay
}

public class Vacation {
    public static void main(String... unused) {
        final DaysOff input = DaysOff.Thanksgiving;
        switch (input) {
            default:
            case ValentinesDay:
                System.out.print("1");
            case PresidentsDay:
                System.out.print("2");
        }
    }

}
