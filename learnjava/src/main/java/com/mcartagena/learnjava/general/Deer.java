package com.mcartagena.learnjava.general;

public class Deer {
    enum Food {APPLES, BERRIES, GRASS}
    protected class Diet{
        private Food getFavorite(){
            return Food.BERRIES;
        }
    }

    public static void main(String[] args) {
        switch (new Deer().new Diet().getFavorite()){
            case APPLES:
                System.out.println("a");
            case BERRIES:
                System.out.println("b");
            default:
                System.out.println("c");
        }
    }
}
