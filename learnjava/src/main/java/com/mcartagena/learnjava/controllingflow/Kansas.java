package com.mcartagena.learnjava.controllingflow;

public class Kansas {
    public static void main(String[] args) {
        int colorOfRainbow = 10;
        final int red = 5;
        switch (colorOfRainbow) {
            default:
                System.out.print("Home");
                break;
            case red:
                System.out.print("Away");
        }

        System.out.println("\n---------------------");
        new Kansas().codeFlow();

    }

    public void magic() {
        int dos = 2;
        int trick = 0;
        LOOP:
        do {
            do {
                trick++;
            } while (trick < dos--);
            continue LOOP;
        } while (1 > 2);
        System.out.println(trick);
    }

    public void codeFlow(){
        letters: for (char ch='a'; ch <= 'z'; ch++){
            numbers: for (int n =0; n<=10; n++){
                System.out.print(ch);
                continue numbers;
            }
        }
    }

}
