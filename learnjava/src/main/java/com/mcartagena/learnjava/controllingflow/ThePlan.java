package com.mcartagena.learnjava.controllingflow;

import java.util.List;

public class ThePlan {
    public static void main(String[] args) {
        var plan = 1;
        plan = plan++ + --plan;
        if (plan == 1) {
            System.out.print("Plan A");
        } else {
            if (plan == 2) System.out.print("Plan B" + " plan=" + plan);
            else System.out.print("Plan C");
        }

        System.out.println("-------------");
        var bottles = List.of("glass", "plastic", "can");
        for (int type = 1; type < bottles.size();) {
            System.out.print(bottles.get(type) + "-");
            if(type < bottles.size()) break;
        }
        System.out.print("end");

        System.out.println("-----------------");
        final var GOOD = 100;
        var score = 10;
        switch (score) {
            default:
                case 1 : System.out.print("1-");
                case -1 : System.out.print("2-"); break;
            case 4 : System.out.print("3-");
            case 5:
                System.out.print("5-");
            case 6 : System.out.print("4-");
            case 9 : System.out.print("5-");
        }

    }

}
