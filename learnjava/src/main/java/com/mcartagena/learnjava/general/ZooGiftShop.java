package com.mcartagena.learnjava.general;

public class ZooGiftShop {
    abstract class SalesTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SalesTodayOnly sale = new SalesTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();
    }

    public static void main(String[] args) {
        ZooGiftShop zooGiftShop = new ZooGiftShop();

        System.out.println(zooGiftShop.admission(10));
    }
}
