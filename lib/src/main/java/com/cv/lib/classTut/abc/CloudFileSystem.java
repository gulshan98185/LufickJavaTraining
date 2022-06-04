package com.cv.lib.classTut.abc;

import com.cv.lib.classTut.FileSystem;

abstract public class CloudFileSystem extends FileSystem {
    boolean isConnectionAvailable;
    boolean isUploadedSomeTimeBefore;
    int noOfDownloads;

    public abstract void upload(boolean isUploadedSomeTimeBefore);


    public CloudFileSystem(int size, String name, String type, long createdTime, boolean isConnectionAvailable, boolean isUploadedSomeTimeBefore, int noOfDownloads) {
        super(size, name, type, createdTime);
        this.isConnectionAvailable = isConnectionAvailable;
        this.isUploadedSomeTimeBefore = isUploadedSomeTimeBefore;
        this.noOfDownloads = noOfDownloads;
        System.out.println("CloudFileSystem is running");
    }

    @Override
    public abstract void copy();

    @Override
    public void move() {
        System.out.println("Cloud is moving something");
    }

    @Override
    public void share() {
        System.out.println("Cloud is sharing something");
    }

    @Override
    public abstract void rename(String name);

    @Override
    protected void run() {
        System.out.println("CloudFileSystem is running");
    }
}
