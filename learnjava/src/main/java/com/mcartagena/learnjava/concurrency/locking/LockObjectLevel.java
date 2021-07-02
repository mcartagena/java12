package com.mcartagena.learnjava.concurrency.locking;

public class LockObjectLevel {

    private final Object ollLock = new Object();  // monitor

    public static void main(String[] args) throws InterruptedException {
        LockObjectLevel lockObjectLevel = new LockObjectLevel();

        System.out.println("Synchronized method case...");

        Thread thread1 = new Thread(() -> {
            try {
                lockObjectLevel.methodOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                lockObjectLevel.methodOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread " + thread1.getName() + " status " + thread1.getState());
        System.out.println("Thread " + thread2.getName() + " status " + thread2.getState());

        thread1.start();
        thread2.start();

        System.out.println("Thread " + thread1.getName() + " status " + thread1.getState());
        System.out.println("Thread " + thread2.getName() + " status " + thread2.getState());

        System.out.println("Synchronized block of code...");

        Thread thread3 = new Thread(() -> {
            try {
                lockObjectLevel.methodBlockOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                lockObjectLevel.methodBlockOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread " + thread3.getName() + " status " + thread3.getState());
        System.out.println("Thread " + thread4.getName() + " status " + thread4.getState());

        thread3.start();
        thread4.start();

        System.out.println("Thread " + thread3.getName() + " status " + thread3.getState());
        System.out.println("Thread " + thread4.getName() + " status " + thread4.getState());

        System.out.println("Synchronized block of code with another object...");

        Thread thread5 = new Thread(() -> {
            try {
                lockObjectLevel.anotherMethodBlockOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                lockObjectLevel.anotherMethodBlockOLL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread " + thread5.getName() + " status " + thread5.getState());
        System.out.println("Thread " + thread6.getName() + " status " + thread6.getState());

        thread5.start();
        thread6.start();

        System.out.println("Thread " + thread5.getName() + " status " + thread5.getState());
        System.out.println("Thread " + thread6.getName() + " status " + thread6.getState());

    }

    public synchronized void methodOLL() throws InterruptedException {
        System.out.println("Lock through syncronized method...");
        Thread.sleep(2000);
    }

    public void methodBlockOLL() throws InterruptedException {
        synchronized (this){
            System.out.println("Lock through syncronized block method...");
            Thread.sleep(2000);
        }
    }

    public void anotherMethodBlockOLL() throws InterruptedException{
        synchronized (ollLock){
            System.out.println("Lock through syncronized block with another object method...");
            Thread.sleep(2000);
        }
    }

}
