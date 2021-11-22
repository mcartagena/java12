package com.mcartagena.learnjava.general;

public class Ghost {
    public static void boo() {
        System.out.println("Not scared");
    }

    protected final class Spirit {
        public void boo() {
            System.out.println("Boo!!!");
        }
    }

    public static void main(String[] args) {
        var g = new Ghost().new Spirit();
        new Ghost().boo();
        Ghost.boo();
    }

    final void recite(final int chapter){
        switch (chapter){
            case 2:
                System.out.println(9);
            default:
                System.out.println(3);
        }
    }
}
