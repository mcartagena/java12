package com.mcartagena.learnjava.controllingflow;

public class Dance {
    public static void main(String[] args) {
        var singer = 0;
        while (singer==0)  // if singer is alon it DON'T COMPILE
            System.out.print(singer++);

        System.out.println("--------");

        int count = 0;
        var stops = new String[] { "Washington", "Monroe",
                "Jackson", "LaSalle" };
        while (count < stops.length)
            if (stops[++count].length() < 8)
                break;
            else continue;
        System.out.println(count);

        System.out.println();
        boolean balloonInflated = false;
        do {
            if (!balloonInflated) {
                balloonInflated = true;
                System.out.print("inflate-");
            }
        } while (! balloonInflated);
        System.out.println("done");

    }
}
