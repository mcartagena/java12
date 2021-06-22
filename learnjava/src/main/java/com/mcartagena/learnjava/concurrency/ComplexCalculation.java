package com.mcartagena.learnjava.concurrency;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */

        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2,power2);

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = thread1.getResult().add(thread2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for(BigInteger baseIterator = BigInteger.ZERO; !baseIterator.equals(power) ; baseIterator = baseIterator.add(BigInteger.ONE) ){
                this.result = this.result.multiply(this.base);
            }
        }

        public BigInteger getResult() { return result; }
    }
}
