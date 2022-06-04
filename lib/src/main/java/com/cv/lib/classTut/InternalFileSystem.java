package com.cv.lib.classTut;

public class InternalFileSystem extends FileSystem{
    void go(){
        int a = 1;
        float b = 1;

        //same method name with different parameters
        doWork(a);
        doWork(b);
    }

    @Override
    public void doWork(int a) {

    }

    @Override
    public void doWork(float a) {

    }

    @Override
    public void doWork(int a, String b) {

    }

    InternalFileSystem(int size, String name, String type, long createdTime) {
        super(size, name, type, createdTime);
    }

    @Override
    public void copy() {
        donate(5);
    }

    @Override
    public void move() {

    }

    @Override
    public void share() {

    }

    @Override
    public void rename(String name) {

    }

    @Override
    protected void run() {
        super.run();
    }

}
