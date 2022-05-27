package com.cv.lib.abc;

public class OneDrive extends CloudFileSystem{
    public OneDrive(int size, String name, String type, long createdTime, boolean isConnectionAvailable, boolean isUploadedSomeTimeBefore, int noOfDownloads) {
        super(size, name, type, createdTime, isConnectionAvailable, isUploadedSomeTimeBefore, noOfDownloads);
        System.out.println("Hum apna marzi ka krege");
    }

    @Override
    public void copy() {

    }

    @Override
    protected void run() {
        super.run();
    }

    @Override
    public void share() {
        super.share();
    }

    @Override
    public void rename(String name) {

    }

    @Override
    public void upload(boolean isUploadedSomeTimeBefore) {
        if (isUploadedSomeTimeBefore){
            System.out.println("Give me money");
        }
    }
}
