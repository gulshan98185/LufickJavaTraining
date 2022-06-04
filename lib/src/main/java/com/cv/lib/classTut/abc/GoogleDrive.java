package com.cv.lib.classTut.abc;

public class GoogleDrive extends CloudFileSystem{
    @Override
    public void upload(boolean isUploadedSomeTimeBefore) {
        if (isUploadedSomeTimeBefore){
            System.out.println("Give me money");
        }
    }

    public GoogleDrive(int size, String name, String type, long createdTime, boolean isConnectionAvailable, boolean isUploadedSomeTimeBefore, int noOfDownloads) {
        super(size, name, type, createdTime, isConnectionAvailable, isUploadedSomeTimeBefore, noOfDownloads);
        System.out.println("Hum apna marzi ka krege");
    }

    @Override
    public void copy() {

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
}
