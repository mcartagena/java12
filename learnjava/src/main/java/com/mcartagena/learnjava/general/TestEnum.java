package com.mcartagena.learnjava.general;

enum Season{
    WINTER("low"), SPRING("medium"), SUMMER("high"), FALL("medium");
    final String expectedVisitors;

    Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

}

public class TestEnum {
    public static void main(String[] args) {

        Season s = Season.valueOf("SUMMER");
        switch (s){
            case FALL:
                System.out.println("don't compile if you put Season.FALL");
                break;
            case SPRING:
                System.out.println("don't compile if you put 0");
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("It is summer yet?");
        }

        for(Season season: Season.values()){
            System.out.println(season.name() + " " + season.ordinal());
        }
    }
}
