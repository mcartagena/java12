package com.mcartagena.learnjava.general;

interface Walk{
    default int getSpeed(){
        return 5;
    }
}

interface Run{
    default int getSpeed(){
        return 10;
    }
}

public class Cat implements Walk, Run {
    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }

    @Override
    public int getSpeed() {
        return Walk.super.getSpeed();
    }
}
