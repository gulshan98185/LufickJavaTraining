package com.lufick.java_lib;

public class ThreadsExample2 {

    public static void main(String args[]) {

        MyThread myTask = new MyThread();
        Thread thread = new Thread(myTask);
        thread.setName("My Custom Thread");
        thread.start();
        myTask.taskCompleteCallback = new TaskCompleteCallback() {
            @Override
            public void onTaskCompleted() {
                System.out.println("Got response from server");
            }
        };


        System.out.println("Main Completed");
    }

    static class MyThread implements Runnable {
        TaskCompleteCallback taskCompleteCallback;
        //@Override
        public void run() {
            /*while(true){
                perform();
                wait();
            }*/
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Running in bg thread:" + Thread.currentThread().getName());
            }
            taskCompleteCallback.onTaskCompleted();
        }
    }

    static interface TaskCompleteCallback {
        public void onTaskCompleted();
    }
}


