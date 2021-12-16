package com.mcartagena.learnjava.controllingflow;

import java.util.List;

public class TourBus {
    public static void main(String... args) {
        var nycTour = new String[]{"Downtown", "Uptown",
                "Brooklyn"};
        var times = new String[]{"Day", "Night"};
        for (int i = 0, j = 1; i < nycTour.length && j < times.length; i++, j++)
            System.out.println(nycTour[i] + "-" + times[j]);

        System.out.println();

        List prnt = List.of(68, 70);
        new TourBus().travel(prnt);

        System.out.println();
        new TourBus().testingVarType();

    }

    public void suprimingBraces() {
        int secret = 0;
        for (int i = 0; i < 10; i++)
            while (i < 10)
                if (i == 5)
                    System.out.println("if");
                else {
                    System.out.println("in");
                    System.out.println("else");
                }


        switch (secret) {
            case 0:
                System.out.println("zero");
        }
    }

    public void travel(List<Integer> roads) {
        for (int w = 1; w <= roads.size(); w++)
            System.out.print(roads.get(w - 1));
//        for (var z : roads)
//            System.out.print(z);
    }

    public void testingVarType() {
        final var javaVersions = List.of(9, 10, 11);
        var exams = List.of("1Z0-811", "1Z0-819");
        V:
        for (var e1 : javaVersions) {
            E:
            for (String e2 : exams)
                System.out.println(e1 + "_" + e2);
            break;
        }
    }

}
