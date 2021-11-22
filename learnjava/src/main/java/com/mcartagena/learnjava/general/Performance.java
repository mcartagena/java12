package com.mcartagena.learnjava.general;
interface Speak { default int talk() { return 7; } }
interface Sing1 { default int talk() { return 5; } }

public class Performance implements Speak {
    public int talk(String... x) {
        return x.length;
    }
    public static void main(String[] notes) {
        System.out.print(new Performance().talk());
    }
}

