package com.cv.lib;

public class InternalFileSystem extends FileSystem{

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
