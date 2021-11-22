package com.mcartagena.learnjava.general;

public class Canine {
    public String woof(int bark) {
        return "1"+ bark;
    }

    public String woof(Integer bark) {
        return "2"+bark.toString();
    }

    public String woof(Object bark) {
        return "3"+bark.toString();
    }

    public static void main(String[] a) {
        System.out.println(new Canine().woof((short)5));
    }
}
