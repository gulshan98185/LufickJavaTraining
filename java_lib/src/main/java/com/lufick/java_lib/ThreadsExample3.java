package com.lufick.java_lib;

public class ThreadsExample3 {
    public static final Object lockObject = new Object();

    public static void main(String args[]) {

        final Object lock = new Object();
        MyThread myTask = new MyThread(lock);
        myTask.start();

        MyThread myTask2 = new MyThread(lock);
        myTask2.start();

        MyThread myTask3 = new MyThread(lock);
        myTask3.start();
        //MyThread myTask2 = new MyThread(lock);
        //MyThread myTask3 = new MyThread(lock);

        /*MyThread myTask4 = new MyThread(new Object());
        MyThread myTask5 = new MyThread(new Object());
        MyThread myTask6 = new MyThread(new Object());*/

        /*Thread thread1 = new Thread(myTask, "Thread 1 sync");
        Thread thread2 = new Thread(myTask, "Thread 2 sync");
        Thread thread3 = new Thread(myTask, "Thread 3 sync");*/

        /*Thread thread4 = new Thread(myTask4, "Thread 4");
        Thread thread5 = new Thread(myTask5, "Thread 5");
        Thread thread6 = new Thread(myTask6, "Thread 6");*/

        /*thread1.start();
        thread2.start();
        thread3.start();*/
        /*thread4.start();
        thread5.start();
        thread6.start();*/
        /*myTask1.taskCompleteCallback = new TaskCompleteCallback() {
            @Override
            public void onTaskCompleted() {
                System.out.println("Got response from server");
            }
        };
        myTask2.taskCompleteCallback = new TaskCompleteCallback() {
            @Override
            public void onTaskCompleted() {
                System.out.println("Got response from server");
            }
        };
        myTask3.taskCompleteCallback = new TaskCompleteCallback() {
            @Override
            public void onTaskCompleted() {
                System.out.println("Got response from server");
            }
        };*/


        System.out.println("Main Completed");
    }

    static class MyThread extends Thread {
        ThreadsExample2.TaskCompleteCallback taskCompleteCallback;
        final Object lock;

        public MyThread(Object lock) {
            this.lock = lock;
        }

        //@Override
        public synchronized void run() {
            //read();
            //synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Running in bg thread:" + Thread.currentThread().getName());
                }
                //taskCompleteCallback.onTaskCompleted();
            //}
        }

        public void read() {
            System.out.println("Running in bg thread:" + Thread.currentThread().getName());
        }
    }
}