package com.lufick.java_lib;

public class ThreadsExample {

    public static void main(String args[]) {

        /*System.out.println("Hello world");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");*/

        MyThread t = new MyThread();
        Thread thread = new Thread(t);
        thread.setName("My Custom Thread");
        thread.start();
        System.out.println("Main Completed");
    }

    static class MyThread implements Runnable {
        //@Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Running in bg thread:" + Thread.currentThread().getName());
            }
        }
    }
}
