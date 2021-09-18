package com.mcartagena.learnjava.general;

interface Sing {
    boolean isTooLoud(int volume, int limit);
}

interface Hervivore{
    int amount = 10;
    static boolean gather = true;
    public static void eatGrass(){}
    default float rest(){ return 2;}
    private static void eatLeaves() {}
}

public class OperaSinger {
    public static void main(String[] args) {
        check((new Sing() {
            @Override
            public boolean isTooLoud(int volume, int limit) {
                return false;
            }
        }), 5);
    }

    private static void check(Sing sing, int volume) {
        if (sing.isTooLoud(volume, 10))
            System.out.println("Not to great");
        else System.out.println("great");
    }
}
