package com.mcartagena.learnjava.makingdecisions;

public class CleaningSchedule {
    public static void main(String[] args) {

        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
//                    continue;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
    }
}
