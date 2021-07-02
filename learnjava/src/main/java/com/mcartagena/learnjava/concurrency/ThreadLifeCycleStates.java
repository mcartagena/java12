package com.mcartagena.learnjava.concurrency;

public class ThreadLifeCycleStates {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadForTest());
        Thread thread2 = new Thread(new ThreadForTest());

        System.out.println("Thread " + thread1.getName() + " status: " + thread1.getState());
        System.out.println("Thread " + thread2.getName() + " status: " + thread1.getState());

        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + thread1.getName() + " status: " + thread1.getState());
        System.out.println("Thread " + thread2.getName() + " status: " + thread2.getState());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + thread1.getName() + " status: " + thread1.getState());
        System.out.println("Thread " + thread2.getName() + " status: " + thread2.getState());

    }

    private static class ThreadForTest implements Runnable {

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread " + Thread.currentThread().getName() + " status: " + currentThread.getState());

            Thread threadInternal = new Thread(() ->
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("WaitingThread currentThread: "
                        + currentThread.getState());
            }
            );

            threadInternal.start();
            try {
                threadInternal.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            blockedMethod();
        }

        public static synchronized void blockedMethod() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is in blockedMethod...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
